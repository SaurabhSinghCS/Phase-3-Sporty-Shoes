package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.Admin;

public interface AdminRepository {
	
	public List<Admin> findAll();
	
	public Admin findAdmin(int Admin_id);
	
	public void saveOrUpdate(Admin admin);


}
