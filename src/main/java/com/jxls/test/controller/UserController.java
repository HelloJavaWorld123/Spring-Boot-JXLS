package com.jxls.test.controller;

import com.jxls.test.dto.User;
import com.jxls.test.service.UserService;
import com.jxls.test.utils.AppResultObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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




}
