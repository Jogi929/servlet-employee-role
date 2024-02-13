package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ty.dto.Profile;
import com.ty.dto.Task;
import com.ty.dto.Users;

public class Connection_User {
	public static EntityManagerFactory entity_manager_factory;
	public static EntityManager entity_manager;
	public static EntityTransaction entity_transaction;
	
	static {
		entity_manager_factory=Persistence.createEntityManagerFactory("vikas");
		entity_manager=entity_manager_factory.createEntityManager();
		entity_transaction=entity_manager.getTransaction();
	}
	
	
	
	public static Users registerUser(String name,String email,String password,String role,String designation,String salary) {
		
		//converting the string to double
		double convert_salary=Double.parseDouble(salary);
		
		//setting the entered values to the user object
		Users user =new Users();
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		user.setDesignation(designation);
		user.setSalary(convert_salary);
		
		//creating the empty array list
		List<Task> tasks=new ArrayList<Task>();
		user.setTasks(tasks);
		
		//persisting the user to the database
		entity_transaction.begin();
		entity_manager.persist(user);
		entity_transaction.commit();
		
		return user;
	}

	//User Validation with respect to database
	public static Users valid_User(String email, String password) {
		
		Users user=entity_manager.find(Users.class,new Profile(email,password));
		
		return user;
	}

	public static List<Users> assignUser() {
		
		Query query=entity_manager.createQuery("select u from Users u where u.role='Employee'");
		
		List<Users> user_list=query.getResultList();
		
		return user_list;
	}
	
	
	public static Users getUser(Profile profile) {
		
		
		Users employee= entity_manager.find(Users.class, profile);
		entity_transaction.begin();
		entity_manager.refresh(employee);
		entity_transaction.commit();
		
		return employee;
	}

}
