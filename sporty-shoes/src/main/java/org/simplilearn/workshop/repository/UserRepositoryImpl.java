package org.simplilearn.workshop.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.simplilearn.workshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> findAllUsers() {
		
		// getting current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		//Executing query
		Query<User> query = currentSession.createQuery("from User",User.class);
				
		// storing order details in a list
		List<User> user = query.getResultList();
				
		return user;
		
	}

	@Override
	public User findUser(int User_id) {
		
		// getting current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Executing query
		Query<User> query = currentSession.createQuery("from User where User_id="+User_id,User.class);
				
		// storing order details in a object
		User user = query.getSingleResult();
		
				
		return user;
		
	}
	
	

}
