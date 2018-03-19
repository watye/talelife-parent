package com.talelife.myproject.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talelife.myproject.model.User;
import com.talelife.myproject.service.UserService;
import com.talelife.myproject.service.UserService.UserQuery;
import com.talelife.util.Page;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/all")
    public List<User> all() {
        return userService.findAll();
    }
	
	@RequestMapping("/page")
    public Page<User> page() {
		UserQuery query = new UserQuery();
		query.setPageNum(2);
		query.setPageSize(1);
        return userService.findPage(query);
    }

	@RequestMapping("/add")
    public void add() {
		User user = new User();
		user.setAge(11);
		user.setUsername("李1");
        userService.add(user);
    }
	
	
	
}
