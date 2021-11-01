package com.example.demo.Tasks.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Tasks.models.TaskDefinition;

@Service
public class TasksService {
	@Autowired  
	TasksRepository tasksRepository; 	
	
	public List<TaskDefinition> getTasks() {
		List<TaskDefinition> rtnList = new ArrayList<>();  
		tasksRepository.findAll().forEach(taskDefinition -> rtnList.add(taskDefinition));
		return rtnList;	
	}
	
	public TaskDefinition addTask(String taskText) {
		TaskDefinition taskDefinition = new TaskDefinition();
		taskDefinition.setText(taskText);
		tasksRepository.save(taskDefinition);
		return taskDefinition;
	}	
	
	public TaskDefinition addTask(TaskDefinition taskDefinition) {
		tasksRepository.save(taskDefinition);
		return taskDefinition;
	}	
	
	public int delTasks() {
		int rtncnt = ((Long) tasksRepository.count()).intValue();
		tasksRepository.deleteAll();
		return rtncnt;
	}	
	
	
}
