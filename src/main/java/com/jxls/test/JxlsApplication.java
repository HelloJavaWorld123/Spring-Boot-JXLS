package com.jxls.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

/**
 * Created By User: RXK
 * Date: 2017/9/13
 * Time: 17:08
 * Version: V1.0
 * Description:
 */
@SpringBootApplication
@MapperScan(annotationClass=Repository.class,basePackages={"com.jxls.test"})
@ComponentScan(basePackages={"com.jxls.test"})
public class JxlsApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(JxlsApplication.class,args);
	}
}
