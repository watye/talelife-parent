package com.talelife.auth.mapper;
import com.talelife.auth.model.User;
import java.util.List;
/**
 * 用户数据操作接口
 * date: 2017-11-15 14:18:56
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

	User findByUsername(String username);
}