package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.User;

public interface UserService {

	public List<User> findAllUsers();
	
	public User findUser(int User_id);
}
