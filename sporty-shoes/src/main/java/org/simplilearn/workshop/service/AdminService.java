package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Admin;

public interface AdminService {

	public List<Admin> findAll();
	
	public Admin findAdmin(int Admin_id);
	
	public void saveOrUpdate(Admin admin);

}
