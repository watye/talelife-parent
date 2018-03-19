package com.talelife.myproject.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.talelife.myproject.service.UserService;

/**
 * 用户测试用例
 * date: 2017-08-17 17:54:46
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/spring-context.xml")
public class UserTest {
	 @Autowired
	 private UserService userService;
	 
	 @Test
	 public void testFindAll(){
		 userService.findAll();
	 }
}
