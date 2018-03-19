package com.talelife.myproject.mapper;
import java.util.List;

import com.github.pagehelper.Page;
import com.talelife.myproject.model.User;
import com.talelife.myproject.service.UserService.UserQuery;
/**
 * 用户数据操作接口
 * date: 2017-08-17 17:54:46
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public interface UserMapper{
	List<User> findAll();
	
	List<User> findList(User user);
	
	int add(User user);
	
	int update(User user);
	
	User findByPK(Long id);
	
	int delete(Long id);

	Page<User> findPage(UserQuery query);
}