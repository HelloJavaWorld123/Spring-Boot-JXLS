package com.jxls.test.utils;

import ch.qos.logback.core.joran.conditional.ElseAction;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jxls.area.Area;
import org.jxls.command.AbstractCommand;
import org.jxls.command.Command;
import org.jxls.common.CellData;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.Size;
import org.jxls.transform.Transformer;
import org.jxls.transform.jexcel.JexcelTransformer;
import org.jxls.transform.poi.PoiCellData;
import org.jxls.transform.poi.PoiTransformer;

/**
 * Created By User: RXK
 * Date: 2017/9/15
 * Time: 11:10
 * Version: V1.0
 * Description:
 */
public class MerageCommand extends AbstractCommand
{
	//定义属性
	private String cols;
	private String rows;
	private Area area;

	//单元格的样式
	private CellStyle cellStyle;

	@Override
	public String getName()
	{
		return "merage";
	}

	@Override
	public Command addArea(Area area){
		if(super.getAreaList().size()>=1)
		{
			throw new IllegalArgumentException("You can add only a single area to 'merge' command");
		}
		this.area = area;
		return super.addArea(area);
	}


	@Override
	public Size applyAt(CellRef cellRef, Context context)
	{
		int rows =1 ,cols =1;

		if(StringUtils.isNotBlank(this.rows))
		{
			Object evaluate = getTransformationConfig().getExpressionEvaluator().evaluate(this.rows, context.toMap());
			if(evaluate != null && NumberUtils.isDigits(evaluate.toString()))
			{
				rows = NumberUtils.toInt(evaluate.toString());
			}
		}

		if(StringUtils.isNotBlank(this.cols))
		{
			Object evaluate = getTransformationConfig().getExpressionEvaluator().evaluate(this.cols, context.toMap());
			if(null != evaluate && NumberUtils.isDigits(evaluate.toString()))
			{
				cols = NumberUtils.toInt(evaluate.toString());
			}
		}

		if(rows > 1 || rows >1)
		{
			Transformer transformer = this.getTransformer();
			if(transformer instanceof PoiTransformer)
			{
				return poiMerage(cellRef,context,(PoiTransformer)transformer,rows,cols);
			}else if(transformer instanceof JexcelTransformer) {
				return JexlMerage(cellRef,context,(JexcelTransformer)transformer,rows,cols);
			}
		}
		area.applyAt(cellRef,context);
		return new Size(1,1);
	}


	protected Size JexlMerage(CellRef cellRef, Context context, JexcelTransformer transformer, int rows, int cols)
	{
		try
		{
			transformer.getWritableWorkbook().getSheet(cellRef.getSheetName()).mergeCells(
					cellRef.getRow(),
					cellRef.getCol(),
					cellRef.getRow()+rows-1,
					cellRef.getCol()+cols-1
			);
			area.applyAt(cellRef,context);
			return new Size(cols,rows);
		} catch (WriteException e)
		{
			e.printStackTrace();
			throw new IllegalArgumentException("合并单元格失败");
		}
	}

	//POI下的transformar 设置单元格的合并
	protected Size poiMerage(CellRef cellRef, Context context, PoiTransformer transformer, int rows, int cols)
	{
		Sheet sheet = transformer.getWorkbook().getSheet(cellRef.getSheetName());
		CellRangeAddress rang = new CellRangeAddress(
				rows,
				cellRef.getRow()+rows-1,
				cols,
				cellRef.getCol()+cols-1
		);
		sheet.addMergedRegion(rang);
		//设置单元格的样式
		if(cellStyle == null)
		{
			PoiCellData cellData = (PoiCellData)transformer.getCellData(cellRef);
			if(cellData != null)
			{
				cellStyle = cellData.getCellStyle();
			}
		}
		//设置每一个单元格的样式
		setRangeStyle(cellStyle,rang,sheet);
		return new Size(cols,rows);
	}

	//从工作本中获取到每一行，再从每一行中获取到每一个单元格，为每一个单元格设置样式
	private void setRangeStyle(CellStyle cellStyle, CellRangeAddress rang, Sheet sheet)
	{
		int l = rang.getLastRow();
		for(int i= rang.getFirstRow();i<=l;i++)
		{
			Row row = sheet.getRow(i);
			if(null == row){
				row = sheet.createRow(i);
			}

			for(int j = rang.getFirstColumn();j<=rang.getLastColumn();j++)
			{
				Cell cell = row.getCell(j);
				if(null == cell)
				{
					cell = row.createCell(j);

				}
				cell.setCellStyle(cellStyle);
			}

		}
	}


	public String getCols()
	{
		return cols;
	}

	public void setCols(String cols)
	{
		this.cols = cols;
	}

	public String getRows()
	{
		return rows;
	}

	public void setRows(String rows)
	{
		this.rows = rows;
	}

	public Area getArea()
	{
		return area;
	}

	public void setArea(Area area)
	{
		this.area = area;
	}

	public CellStyle getCellStyle()
	{
		return cellStyle;
	}

	public void setCellStyle(CellStyle cellStyle)
	{
		this.cellStyle = cellStyle;
	}
}
