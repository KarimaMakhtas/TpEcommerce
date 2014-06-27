package com.epsi.TPOracle.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epsi.TPOracle.dao.UserDao;
import com.epsi.TPOracle.entities.User;

@Service
public class UserService {
    
	@Autowired
	UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public User userCanLogin(String login, String password) {
		
		return null;
	}

	public User find(int id) {
		return userDao.find(id);
		
	}
	
	public boolean emailExiste(String email){
		return true;
	}
	
	public boolean passwordMatchWithEmail(String email,String password){
		return true;
	}
	
	public User getUserByEmail(String email){
		return null;
	}
	
	public Integer createUser(User user){
		return userDao.save(user);
	}
	

	
}