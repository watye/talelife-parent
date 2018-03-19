package com.talelife.myproject.service;
import java.util.List;

import com.talelife.myproject.model.User;
import com.talelife.util.Page;
/**
 * 用户业务接口
 * date: 2017-08-17 17:54:46
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public interface UserService{
	List<User> findAll();
	
	List<User> findList(User user);
	
	Page<User> findPage(UserQuery query);
	
	int add(User user);
	
	int delete(Long id);
	
	int update(User user);
	
	User findByPK(Long id);
	
	public static class UserQuery extends User{

		private static final long serialVersionUID = 2267247332350702957L;
		private Integer pageNum=1;
		private Integer pageSize=Page.DEFAULT_PAGE_SIZE;
		public Integer getPageNum() {
			return pageNum;
		}
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
	}
}