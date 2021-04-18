package org.simplilearn.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Admin_id")
	private int id;
	
	@Column(name = "Admin_FirstName")
	private String FirstName;
	
	@Column(name = "Admin_LastName")
	private String LastName;
	
	@Column(name = "Admin_UserName")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String UserName;
	
	@Column(name = "Admin_password")
	private String password;

	public Admin() {
		super();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	@Override
	public String toString() {
		return String.format("Admin [id=%s, FirstName=%s, LastName=%s, UserName=%s, password=%s]", id, FirstName,
				LastName, UserName, password);
	}
	
	
}
