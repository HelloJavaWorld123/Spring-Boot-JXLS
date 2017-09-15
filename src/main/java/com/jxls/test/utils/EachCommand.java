package com.jxls.test.utils;

import org.jxls.area.Area;
import org.jxls.command.AbstractCommand;
import org.jxls.command.CellRefGenerator;
import org.jxls.command.Command;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.Size;

/**
 * Created By User: RXK
 * Date: 2017/9/15
 * Time: 17:51
 * Version: V1.0
 * Description:
 */
public class EachCommand extends AbstractCommand
{
	public enum  Direction
	{
		Right,
		Down
	}

	private String var;
	private String items;
	private String select;
	private Area area ;
	private String mutiSheet;
	private Direction direction = Direction.Down;
	private CellRefGenerator cellRefGenerator;
	//如果某一个单元格的数据为空  那么遍历的时候 同样保留一行的格式
	private String retainEmpty;

	//构造方法重载
	public EachCommand(String var,String items,Direction direction)
	{
		this.var = var;
		this.items = items;
		this.direction = direction == null ? Direction.Down : direction;
	}

	public EachCommand (String var,String items,Area area)
	{
		this(var,items,area,Direction.Down);
	}

	public EachCommand(String var,String items,Area area,Direction direction)
	{
		this(var,items,direction);
		if(null != area)
		{
			this.area = area;
			addArea(this.area);
		}

	}

	@Override
	public String getName()
	{
		return null;
	}

	@Override
	public Command addArea(Area area)
	{
		if(null == area)
		{
			return this;
		}
		if(super.getAreaList().size()>=1)
		{
			throw  new IllegalArgumentException("You can add only a single area to 'each' command");
		}
		this.area = area;
		return super.addArea(area);
	}

	@Override
	public Size applyAt(CellRef cellRef, Context context)
	{
		return null;
	}


}
