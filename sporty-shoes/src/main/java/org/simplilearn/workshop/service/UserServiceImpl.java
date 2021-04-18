package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public List<User> findAllUsers() {
		
		List<User> user = userRepository.findAllUsers();
		
		return user;
		
	}

	@Override
	@Transactional
	public User findUser(int User_id) {
		
		User user = userRepository.findUser(User_id);
		
		return user;
		
	}

}
