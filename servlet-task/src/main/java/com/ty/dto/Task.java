package com.ty.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int task_id;
	private String description;
	
	@CreationTimestamp
	private LocalDateTime assignedTime;
	
	@UpdateTimestamp
	private LocalDateTime completedTime;
	
	private String status;

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", description=" + description + ", assignedTime=" + assignedTime
				+ ", completedTime=" + completedTime + ", status=" + status + "]";
	}
	
	
	
	

}
