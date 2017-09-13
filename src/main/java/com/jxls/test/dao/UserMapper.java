package com.jxls.test.dao;

import com.jxls.test.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By User: RXK
 * Date: 2017/9/13
 * Time: 17:51
 * Version: V1.0
 * Description:
 */
@Repository
public  interface UserMapper
{


	List<User> getUserList();

}
