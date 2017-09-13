package com.jxls.test.service.impl;

import com.jxls.test.dao.UserMapper;
import com.jxls.test.dto.User;
import com.jxls.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created By User: RXK
 * Date: 2017/9/13
 * Time: 17:43
 * Version: V1.0
 * Description:
 */
@Service
@Transactional
public class UserServiceImple implements UserService
{


	@Autowired
	private UserMapper userMapper;


	@Override
	public List<User> getUserList()
	{
		return userMapper.getUserList();

	}
}
