package com.jxls.test.service;

import com.jxls.test.dto.User;

import java.util.List;

/**
 * Created By User: RXK
 * Date: 2017/9/13
 * Time: 17:42
 * Version: V1.0
 * Description:用户Service层
 */
public interface UserService
{
	/**
	 * 获取用户信息列表
	 */
	List<User> getUserList();
}
