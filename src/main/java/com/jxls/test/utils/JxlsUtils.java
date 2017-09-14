package com.jxls.test.utils;

import com.jxls.test.dto.ExcelDTO;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created By User: RXK
 * Date: 2017/9/14
 * Time: 15:04
 * Version: V1.0
 * Description:封装导出excel文件的类
 * 通过的类 只需要传入需要的参数 以及 excel模板 就可以导出excel
 */
public class JxlsUtils
{
	private static Logger LOG = LoggerFactory.getLogger(JxlsUtils.class);

	public static void execl(ExcelDTO template)
	{
		try
		{
			//将包装的数据 封装到Context对象中
			Context context = new Context(template.getData());

			String fileName = URLEncoder.encode(template.getFileName(),"UTF-8");


			HttpServletResponse response = template.getResponse();
			//设置传输的文本的格式：
			response.setHeader("content-disponsition","attchement;filename"+template.getFileName()+".xlsx");
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

			//使用缓冲流
			OutputStream os = response.getOutputStream();

			//会在项目的根目录输出 该文件 测试专用
			String  osName = System.getProperty("os.name");
			if(osName.toLowerCase().startsWith("win")){
				os = new FileOutputStream(fileName +".xlsx");
			}
			//从 类加载器中获取到输入流
			InputStream is = JxlsUtils.class.getClassLoader().getResourceAsStream(template.getFilePath());

			JxlsHelper jxlsHelper = JxlsHelper.getInstance();
			Transformer transformer = jxlsHelper.createTransformer(is, os);

			//TODO 添加自定义的功能

			//两种方式
			jxlsHelper.processTemplate(context,transformer);
			//输入流如果不关闭 会导致 excel文件被占用
			is.close();
		} catch (IOException e)
		{
			LOG.info("导出文件失败：{}",e.getMessage());
			e.printStackTrace();
		}
	}
}
