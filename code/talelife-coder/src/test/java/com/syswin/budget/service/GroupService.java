package com.syswin.budget.service;
import com.syswin.budget.model.Group;
import java.util.List;
/**
 * 组业务接口
 * date: 2017-02-20 10:01:41
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public interface GroupService{
	List<Group> findAll();
	
	List<Group> findList(Group group);
	
	int add(Group group);
	
	int delete(String id);
	
	int update(Group group);
	
	Group findByPK(String id);
}