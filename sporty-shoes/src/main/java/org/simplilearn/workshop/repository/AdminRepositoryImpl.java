package org.simplilearn.workshop.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.simplilearn.workshop.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "adminRepository")
public class AdminRepositoryImpl implements AdminRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Admin> findAll() {
		
		// getting the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// executing the query
		Query<Admin> query = currentSession.createQuery("from Admin", Admin.class);
		
		// storing values in a list
		List<Admin> admin = query.getResultList();
		
		//return the admin
		return admin;

	}

	
	@Override
	public Admin findAdmin(int Admin_id) {
		
		// getting the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// executing the query
		return (Admin) currentSession.createQuery("from Admin where Admin_id = :id", Admin.class).setParameter("id",Admin_id).getSingleResult();
		
	}


	@Override
	public void saveOrUpdate(Admin admin) {
		
		// getting the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// executing the query
		currentSession.saveOrUpdate(admin);
		
	}
	
	
	
	
}
