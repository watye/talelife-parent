package com.syswin.budget.test;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.syswin.budget.service.GroupService;

/**
 * 组测试用例
 * date: 2017-02-20 10:01:41
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/spring-context.xml")
public class GroupTest {
	 @Autowired
	 private GroupService groupService;
	 
	 @Test
	 public void testFindAll(){
		 groupService.findAll();
	 }
}
