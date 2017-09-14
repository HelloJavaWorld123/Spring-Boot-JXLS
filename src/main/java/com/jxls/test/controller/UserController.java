package com.jxls.test.controller;

import com.jxls.test.dto.ExcelDTO;
import com.jxls.test.dto.User;
import com.jxls.test.dto.UserInDTO;
import com.jxls.test.service.UserService;
import com.jxls.test.utils.AppResultObj;
import com.jxls.test.utils.JxlsUtils;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By User: RXK
 * Date: 2017/9/13
 * Time: 17:38
 * Version: V1.0
 * Description:用户控制层
 */
@RestController
@RequestMapping("/api/user")
public class UserController
{
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public AppResultObj getList()
	{
		LOG.info("获取用户信息");
		try{
			List<User> list= userService.getUserList();
			return AppResultObj.success(list);
		}catch (Exception e){
			LOG.debug("获取用户信息失败：{}",e.getMessage());
			e.printStackTrace();
			return AppResultObj.parameterError();
		}

	}


	/**
	 * 使用Excel表格导出用户的信息
	 * @param response
	 * @param dto
	 */
	@RequestMapping(value = "/execl")
	public AppResultObj exportExcelFromDB(HttpServletResponse response, UserInDTO dto){

			try{
				ExcelDTO template = new ExcelDTO();
				//得到数据源
				List<User> userList = userService.getUserList();
				Map<String ,Object > map = new HashMap<>();
				map.put("userList",userList);

				template.setData(map);
				template.setFileName("用户信息列表");
				template.setFilePath("excelTemplate/UserList.xlsx");
				template.setResponse(response);

				JxlsUtils.execl(template);
				return null;

			}catch (Exception e){
				LOG.info("导出表格失败：{}",e.getMessage());
				e.printStackTrace();
				return AppResultObj.serverError();
			}
	}
}
