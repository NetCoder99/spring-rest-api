package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MovieDetailsSW.models.MovieDetailsSWNew;
import com.example.demo.Tasks.models.TaskDefinition;
import com.example.demo.Tasks.utilities.TasksService;
import com.example.demo.models.ErrorResponse;
import com.example.demo.utilities.JSONUtilities;

@RestController
@RequestMapping("/Tasks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TasksController<T> {
	
	@Autowired TasksService     tasksService;
	
	@GetMapping("/getTasks")
	public ResponseEntity<List<TaskDefinition>> getTasks() throws Exception {
		try {
			Thread.sleep(500);
			List<TaskDefinition> rtnList = tasksService.getTasks();
			return new ResponseEntity<List<TaskDefinition>>(rtnList, HttpStatus.OK);
		}
		catch(Exception ex) {
			System.out.println("getTasks.failed:" + ex.getLocalizedMessage());
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addTask", method = { RequestMethod.POST })
	public ResponseEntity<T> addTask(@RequestBody String requestBody) throws Exception {
		try {
			Thread.sleep(500);
			TaskDefinition tmpObj = (TaskDefinition) new JSONUtilities<TaskDefinition>().CreateObjFromJson(requestBody, TaskDefinition.class);				
			TaskDefinition taskDefinition = tasksService.addTask(tmpObj);
			return (ResponseEntity<T>) new ResponseEntity<TaskDefinition>(taskDefinition, HttpStatus.OK);
		}
		catch(Exception ex) {
			System.out.println("addTask.failed:" + ex.getLocalizedMessage());
			ex.printStackTrace();
			return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/delTasks", method = { RequestMethod.GET, RequestMethod.POST  })
	public ResponseEntity<T> delTasks() throws Exception {
		try {
			Thread.sleep(500);
			int delCnt = tasksService.delTasks();
			return (ResponseEntity<T>) new ResponseEntity<String>(delCnt + " tasks deleted", HttpStatus.OK);
		}
		catch(Exception ex) {
			System.out.println("addTask.failed:" + ex.getLocalizedMessage());
			ex.printStackTrace();
			return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
