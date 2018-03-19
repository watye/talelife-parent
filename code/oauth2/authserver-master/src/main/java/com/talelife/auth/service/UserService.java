package com.talelife.auth.service;
import com.talelife.auth.model.User;
import java.util.List;
/**
 * 用户业务接口
 * date: 2017-11-15 14:18:56
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public interface UserService{
	List<User> findAll();
	
	List<User> findList(User user);
	
	int add(User user);
	
	int delete(Long id);
	
	int update(User user);
	
	User findByPK(Long id);
	
	User findByUsername(String username);
}