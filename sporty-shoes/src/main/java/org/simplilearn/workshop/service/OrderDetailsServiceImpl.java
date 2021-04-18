package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Orders;
import org.simplilearn.workshop.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Override
	@Transactional
	public List<Orders> findAllOrders() {
		return orderDetailsRepository.findAllOrders();
	}

}
