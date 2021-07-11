package com.example.demo.Tasks.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TaskDefinition {
	@Id	@Column @GeneratedValue(strategy=GenerationType.AUTO) private int taskId;
	@Column(length = 5000) private String text;
	
	public TaskDefinition() {}
	
	public TaskDefinition(int taskId, String text) {
		super();
		this.taskId = taskId;
		this.text = text;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
