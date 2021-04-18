package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.Product;

public interface ProductRepository {
	
	public List<Product> findAllProducts();
	
	public Product findProduct(int shoes_id);
	
	public void updateProduct(Product product);
	
	public void delete(Product product);

}
