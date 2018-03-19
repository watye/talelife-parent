package com.syswin.budget.mapper;
import com.syswin.budget.model.Group;
import java.util.List;
/**
 * 组数据操作接口
 * date: 2017-02-20 10:01:41
 * 
 * @author Liuweiyao
 * @version 1.0
 */
public interface GroupMapper{
	List<Group> findAll();
	
	List<Group> findList(Group group);
	
	int add(Group group);
	
	int update(Group group);
	
	Group findByPK(String id);
	
	int delete(String id);
}