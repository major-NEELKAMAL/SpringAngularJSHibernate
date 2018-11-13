package com.neelkamal.service;

import java.util.List;

import com.neelkamal.model.User;

public interface UserService {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<User> listUser();
	public User getUserById(int id);
}
