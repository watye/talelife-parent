package com.talelife.auth.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.talelife.auth.service.UserService;
import com.talelife.auth.mapper.UserMapper;
import com.talelife.auth.model.User;
import javax.annotation.Resource;
import java.util.List;
/**
 * 用户业务实现类
 * date: 2017-11-15 14:18:56
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll(){
		return userMapper.findAll();
	}
	
	public List<User> findList(User user){
		return userMapper.findList(user);
	}
	
	public int add(User user){
		return userMapper.add(user);
	}
	
	public int delete(Long id){
		return userMapper.delete(id);
	}
	
	public int update(User user){
		return userMapper.update(user);
	}
	
	public User findByPK(Long id){
		return userMapper.findByPK(id);
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
	
	
	
	
	
}