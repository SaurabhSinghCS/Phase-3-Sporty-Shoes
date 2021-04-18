package org.simplilearn.workshop.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.simplilearn.workshop.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "orderDetailsRepository")
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orders> findAllOrders() {
		
		// getting current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Executing query
		Query<Orders> query = currentSession.createQuery("from Orders",Orders.class);
		
		System.out.println(query);
		// storing order details in a list
		List<Orders> order = query.getResultList();
		
		return order;
	}

}
