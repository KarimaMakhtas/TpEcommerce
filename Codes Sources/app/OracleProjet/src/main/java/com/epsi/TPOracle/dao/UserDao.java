package com.epsi.TPOracle.dao;

import org.springframework.stereotype.Repository;

import com.epsi.TPOracle.entities.User;

@Repository("UserDao")
public class UserDao extends AbstractDao<User,Integer>{
	
	public UserDao(){
		super();
	}
	
	public User find(int id){
		return this.find(User.class,id);
	}
	
	public Integer save(User user){
		return this.save(user);
	}
	
	public void update(User user){
		this.update(user);
	}
	
	public void delete(User user){
		this.delete(user);
	}
	
	
	

}
