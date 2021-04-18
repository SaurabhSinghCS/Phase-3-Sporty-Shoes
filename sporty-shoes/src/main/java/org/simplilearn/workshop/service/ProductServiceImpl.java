package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Product;
import org.simplilearn.workshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public List<Product> findAllProducts() {
		
		return productRepository.findAllProducts();
	}

	@Override
	@Transactional
	public Product findProduct(int shoes_id) {
		
		return productRepository.findProduct(shoes_id);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productRepository.updateProduct(product);
		
	}

	@Override
	@Transactional
	public void delete(Product product) {
		productRepository.delete(product);
		
	}
	
	
	
	

}
