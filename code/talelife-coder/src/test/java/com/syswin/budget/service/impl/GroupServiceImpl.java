package com.syswin.budget.service.impl;
import org.springframework.stereotype.Service;
import com.syswin.budget.service.GroupService;
import com.syswin.budget.mapper.GroupMapper;
import com.syswin.budget.model.Group;
import javax.annotation.Resource;
import java.util.List;
/**
 * 组业务实现类
 * date: 2017-02-20 10:01:41
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@Service
public class GroupServiceImpl implements GroupService{
	
	@Resource
	private GroupMapper groupMapper;
	
	public List<Group> findAll(){
		return groupMapper.findAll();
	}
	
	public List<Group> findList(Group group){
		return groupMapper.findList(group);
	}
	
	public int add(Group group){
		return groupMapper.add(group);
	}
	
	public int delete(String id){
		return groupMapper.delete(id);
	}
	
	public int update(Group group){
		return groupMapper.update(group);
	}
	
	public Group findByPK(String id){
		return groupMapper.findByPK(id);
	}
	
	
	
	
	
}