package com.jxls.test.dto;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created By User: RXK
 * Date: 2017/9/14
 * Time: 14:53
 * Version: V1.0
 * Description:封装 导出excel表格需要的数据的对象
 */
public class ExcelDTO
{
	//文件名称
	private String fileName;
	//文件的路径
	private String filePath;
	//封装的数据
	private Map<String,Object> data;

	//需要响应流对象
	private HttpServletResponse response;


	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public Map<String, Object> getData()
	{
		return data;
	}

	public void setData(Map<String, Object> data)
	{
		this.data = data;
	}

	public HttpServletResponse getResponse()
	{
		return response;
	}

	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}
}
