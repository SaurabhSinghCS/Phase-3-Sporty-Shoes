package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.User;

public interface UserRepository {

	public List<User> findAllUsers();
	
	public User findUser(int User_id);
}
