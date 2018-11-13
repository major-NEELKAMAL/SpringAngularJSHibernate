package com.neelkamal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neelkamal.dao.UserDAO;
import com.neelkamal.model.User;
@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
		
	}
	
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
		
	}
	
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
		
	}

	@Transactional
	public List<User> listUser() {
	
		return userDAO.listUser();
	}

	@Transactional
	public User getUserById(int id) {
		
		return userDAO.getUserById(id);
	}

}
