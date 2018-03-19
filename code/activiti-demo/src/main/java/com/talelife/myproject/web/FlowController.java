package com.talelife.myproject.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flow")
public class FlowController {
	
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	
	@RequestMapping("/start")
    public void start() {
		Map<String,Object> variables = new HashMap<>();
		variables.put("usertask1", 1);
		ExecutionEntity process = (ExecutionEntity)runtimeService.startProcessInstanceByKey("vacate", variables);
		String processId = process.getId();
		System.out.println("processId="+processId);
    }
	
	@RequestMapping("/complete")
    public void complete() {
		Task task = taskService.createTaskQuery().processInstanceId("2501").singleResult();
		taskService.complete(task.getId());
		
    }
	
	@RequestMapping("/get_task")
    public void getTask() {
		TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee("1").orderByDueDateNullsLast().desc();
		List<Task> tasks = taskQuery.listPage(0, 10);
		for (Task task : tasks) {
			System.out.println(task.getName());
		}
    }
	
	@RequestMapping("/deploy")
	public void deploy() {
		repositoryService.createDeployment().addClasspathResource("processes/vacate.bpmn").deploy();
	}
	
}
