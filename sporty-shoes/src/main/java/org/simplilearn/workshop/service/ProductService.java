package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Product;

public interface ProductService {

	public List<Product> findAllProducts();
	
	public Product findProduct(int shoes_id);
	
	public void updateProduct(Product product);
	
	public void delete(Product product);
}
