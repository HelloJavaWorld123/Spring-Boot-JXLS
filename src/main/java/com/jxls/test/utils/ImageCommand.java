package com.jxls.test.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.jxls.area.Area;
import org.jxls.command.AbstractCommand;
import org.jxls.command.Command;
import org.jxls.common.*;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;

/**
 * Created By User: RXK
 * Date: 2017/9/15
 * Time: 17:51
 * Version: V1.0
 * Description:
 */
public class ImageCommand extends AbstractCommand
{


	private byte[] imageBatys;
	private ImageType imageType = ImageType.PNG;
	private Area area;


	private String src ;
	// 当图片不能显示时   显示的 标题
	private String text ;

	//重载构造方法
	public ImageCommand(){

	}

	public ImageCommand(byte[] imageBatys,ImageType imageType){
		this.imageBatys = imageBatys;
		this.imageType = imageType;
	}

	public ImageCommand (String image,ImageType imageType){
		this.src = image ;
		this.imageType = imageType ;
	}

	@Override
	public String getName()
	{
		return "image";
	}

	public String getSrc()
	{
		return src;
	}

	public void setSrc(String src)
	{
		this.src = src;
	}

	public void setImageType(String strImageType){
		imageType = ImageType.valueOf(strImageType);
	}

	@Override
	public Command addArea(Area area){
		if(super.getAreaList().size()>1){
			throw new IllegalArgumentException("");
		}
		 this.area = area;
		return super.addArea(area);
	}
	@Override
	public Size applyAt(CellRef cellRef, Context context)
	{
		if(null == area)
		{
			throw new IllegalArgumentException("NO area for Image Comamd");
		}

		Transformer transformer =  getTransformer();

		Size  size = area.getSize();
		size.setWidth(size.getWidth()+1);
		size.setHeight(size.getHeight()+1);
		AreaRef areaRef = new AreaRef(cellRef,size);
		size.setWidth(size.getWidth()-1);
		size.setHeight(size.getHeight()-1);
		byte[] imgBatys = imageBatys;
		if(null != src){
			Object imageObje = getTransformationConfig().getExpressionEvaluator().evaluate(src, context.toMap());
			if(imageObje != null){
				if(!(imageObje instanceof Byte[])){
					throw new IllegalArgumentException("src value must contain image bytes (byte[])")
				}

				imgBatys = (byte[])imageObje;
			}
			if(imageBatys != null){
				transformer.addImage(areaRef,imageBatys,imageType);
			}
			area.applyAt(cellRef,context);
			if(null == imageBatys && StringUtils.isNotBlank(text)){
				PoiTransformer poiTransformer = (PoiTransformer) transformer;
				Sheet sheet = poiTransformer.getWorkbook().getSheet(cellRef.getSheetName());
				Row row = sheet.getRow(cellRef.getRow());
				if(null != row && row.getCell(cellRef.getCol())!= null){
					row.getCell(cellRef.getCol()).setCellValue(text);
				}
			}
		}
			return size;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
