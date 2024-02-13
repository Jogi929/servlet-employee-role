package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Task;
import com.ty.dto.Users;

public class Connection_Task {
	
	public static EntityManagerFactory entity_manager_factory;
	public static EntityManager entity_manager;
	public static EntityTransaction entity_transaction;
	
	static {
		entity_manager_factory=Persistence.createEntityManagerFactory("vikas");
		entity_manager=entity_manager_factory.createEntityManager();
		entity_transaction=entity_manager.getTransaction();
	}

	public static Task registerTask(String task_description, String employee_assigned, String task_status) {
		
		//creating the task object
		Task task=new Task();
		task.setDescription(task_description);
		task.setStatus(task_status);

		//Assign the task to employee
		Query query=entity_manager.createQuery("select u from Users u where u.email=?1");

		query.setParameter(1, employee_assigned);
		
		Users employee=(Users)query.getResultList().get(0);
		
		//setting the task to user
		List<Task> task_list=employee.getTasks();
		task_list.add(task);
		
		//persist the task and assign to employee
		entity_transaction.begin();
		entity_manager.persist(task);
		entity_manager.merge(employee);
		entity_transaction.commit();
		
		
		return task;	
	}

	public static Task getTaskById(int taskId) {
		
		return entity_manager.find(Task.class, taskId);
	}

	public static Task updateTask(Task task) {
		
        entity_transaction.begin();
        entity_manager.merge(task);
        entity_transaction.commit();
        
        return task;

	}
	
	public static List<Task> updatedTaskList(Users employee){
		
		String query = "Select t from Task t";
		Query q = entity_manager.createQuery(query);
		
		List<Task> tasks = q.getResultList();
		
		List<Task> updatedTaskList = new ArrayList<Task>();
		
		List<Task> employeeTaskList = employee.getTasks();
		
		for(Task t1: employeeTaskList) {
			
			int id = t1.getTask_id();
			for(Task t2: tasks) {
				int id2 = t2.getTask_id();
				if(id == id2) {
					updatedTaskList.add(t2);
				}
			}
			
		}
		
		return updatedTaskList;
		
	}
	
	

}
