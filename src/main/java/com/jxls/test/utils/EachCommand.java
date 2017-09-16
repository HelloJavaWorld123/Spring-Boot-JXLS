package com.jxls.test.utils;

import org.jxls.area.Area;
import org.jxls.command.AbstractCommand;
import org.jxls.command.CellRefGenerator;
import org.jxls.command.Command;
import org.jxls.command.SheetNameGenerator;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.JxlsException;
import org.jxls.common.Size;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.util.Util;

import java.util.Collection;
import java.util.List;

/**
 * Created By User: RXK
 * Date: 2017/9/15
 * Time: 17:51
 * Version: V1.0
 * Description:
 */
public class EachCommand extends AbstractCommand
{
	private String var;
	private String items;
	private String select;
	private Area area;
	private String mutiSheet;
	private Direction direction = Direction.Down;
	private CellRefGenerator cellRefGenerator;
	//如果某一个单元格的数据为空  那么遍历的时候 同样保留一行的格式
	private String retainEmpty;
	//构造方法重载
	public EachCommand(String var, String items, Direction direction)
	{
		this.var = var;
		this.items = items;
		this.direction = direction == null ? Direction.Down : direction;
	}

	public EachCommand(String var, String items, Area area)
	{
		this(var, items, area, Direction.Down);
	}

	public EachCommand(String var, String items, Area area, Direction direction)
	{
		this(var, items, direction);
		if (null != area)
		{
			this.area = area;
			addArea(this.area);
		}
	}

	@Override
	public String getName()
	{
		return "each";
	}

	@Override
	public Command addArea(Area area)
	{
		if (null == area)
		{
			return this;
		}
		if (super.getAreaList().size() >= 1)
		{
			throw new IllegalArgumentException("You can add only a single area to 'each' command");
		}
		this.area = area;
		return super.addArea(area);
	}

	@Override
	public Size applyAt(CellRef cellRef, Context context)
	{
		int width = 0, height = 0, index = 0;
		Collection itemsCollection = Util.transformToCollectionObject(getTransformationConfig().getExpressionEvaluator(), items, context);
		CellRefGenerator cellRefGenerator = this.cellRefGenerator;
		if (cellRefGenerator == null && mutiSheet != null)
		{
			List<String> sheetNames = getSheetNameList(context);
			cellRefGenerator = new SheetNameGenerator(sheetNames, cellRef);
		}
		CellRef currentCell = cellRefGenerator != null ? cellRefGenerator.generateCellRef(index, context) : cellRef;

		//创建Expression
		JexlExpressionEvaluator selectExpression = null;
		if (null != select)
		{
			selectExpression = new JexlExpressionEvaluator(select);
		}

		for (Object obj : itemsCollection)
		{
			context.putVar(var, obj);
			context.putVar(var + "_index", index);

			if (selectExpression != null && !Util.isConditionTrue(selectExpression, context))
			{
				context.removeVar(var);
				context.removeVar(var + "_index");
				continue;
			}
			Size size = area.applyAt(currentCell, context);
			index++;
			if (cellRefGenerator != null)
			{
				width = Math.max(width, size.getWidth());
				height = Math.max(height, size.getHeight());
				if (index < itemsCollection.size())
				{
					currentCell = cellRefGenerator.generateCellRef(index, context);
				}
			} else if (direction == Direction.Down)
			{
				currentCell = new CellRef(currentCell.getSheetName(), currentCell.getRow() + size.getHeight(), currentCell.getCol());
				width = Math.max(width, size.getWidth());
				height += size.getHeight();
			} else
			{
				currentCell = new CellRef(currentCell.getSheetName(), currentCell.getRow(), currentCell.getCol() + size.getHeight());
				width += size.getWidth();
				height = Math.max(height, size.getHeight());
			}

			context.removeVar(var);
			context.removeVar(var + "_index");
		}
		if ("true".equalsIgnoreCase(retainEmpty) && width == 0 && height == 0)
		{
			return area.applyAt(currentCell, context);
		}

		return new Size(width, height);
	}

	private List<String> getSheetNameList(Context context)
	{
		try
		{
			return (List<String>) context.getVar(mutiSheet);
		} catch (Exception e)
		{
			throw new JxlsException("获取文件名失败：{}," + mutiSheet);
		}
	}

	public enum Direction
	{
		Right, Down
	}
}
