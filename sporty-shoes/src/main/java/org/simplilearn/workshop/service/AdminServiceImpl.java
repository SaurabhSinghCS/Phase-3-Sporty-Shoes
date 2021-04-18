package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Admin;
import org.simplilearn.workshop.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	@Transactional
	public List<Admin> findAll() {
		
		return adminRepository.findAll();
		
	}

	@Override
	@Transactional
	public Admin findAdmin(int Admin_id) {
		
		return adminRepository.findAdmin(Admin_id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Admin admin) {
		
		adminRepository.saveOrUpdate(admin);
		
	}
	
	
}
