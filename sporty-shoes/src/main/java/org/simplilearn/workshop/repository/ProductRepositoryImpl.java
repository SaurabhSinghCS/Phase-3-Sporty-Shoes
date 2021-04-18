package org.simplilearn.workshop.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.simplilearn.workshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "productRepository")
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> findAllProducts() {

		// getting the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("from Product",Product.class).getResultList();
	}

	@Override
	public Product findProduct(int shoes_id) {

		// getting the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("from Product where Shoes_id=:id",Product.class)
				.setParameter("id", shoes_id).getSingleResult();
	}

	@Override
	public void updateProduct(Product product) {

		// getting the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(product);
		
	}

	@Override
	public void delete(Product product) {
		
		// getting the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.delete(product);
		
	}
	
	
	
	

}
