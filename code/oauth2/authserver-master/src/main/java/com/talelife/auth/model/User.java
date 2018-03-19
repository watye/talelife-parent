package com.talelife.auth.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 用户实体类
 * date: 2017-11-15 14:18:56
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public class User implements Serializable{
	//
	private Long id;
	
	//用户名
	private String username;
	
	//密码
	private String password;
	

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
 	    this.id=id;
    }
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
 	    this.username=username;
    }
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
 	    this.password=password;
    }

}