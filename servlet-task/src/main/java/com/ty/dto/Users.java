package com.ty.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@IdClass(Profile.class)
public class Users {
	
	private String name;
	@Id
	private String email;
	@Id
	private String password;
	private String role;
	private String designation;
	private double salary;
	
	@CreationTimestamp
	private LocalDateTime registerdTime;
	
	@OneToMany
	private List<Task> tasks;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", designation=" + designation + ", salary=" + salary + ", registerdTime=" + registerdTime
				+ "\n, tasks=" + tasks + "]";
	}
	
	

}
