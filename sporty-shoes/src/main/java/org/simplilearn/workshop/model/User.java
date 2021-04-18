package org.simplilearn.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_id")
	private int id;
	
	@Column(name = "User_FirstName")
	private String FirstName;
	
	@Column(name = "User_LastName")
	private String LastName;
	
	@Column(name = "User_UserName")
	private String UserName;
	
	@Column(name = "User_Email")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String Email;
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return String.format("Users [id=%s, FirstName=%s, LastName=%s, UserName=%s, Email=%s]", id, FirstName, LastName,
				UserName, Email);
	}

	
	
	
}
