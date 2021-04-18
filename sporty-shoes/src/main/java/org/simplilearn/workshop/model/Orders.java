package org.simplilearn.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Order_id")
	private int id;
	
	@Column(name = "Userid")
	private int userId;
	
	@Column(name = "Shoesid")
	private int shoeId;
	
	@Column(name = "date")
	private String date;
	
	
	public Orders() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getShoeId() {
		return shoeId;
	}
	
	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return String.format("OrderDetails [id=%s, userId=%s, shoeId=%s, date=%s]", id, userId, shoeId, date);
	}


	

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setShoeId(int shoeId) {
		this.shoeId = shoeId;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
