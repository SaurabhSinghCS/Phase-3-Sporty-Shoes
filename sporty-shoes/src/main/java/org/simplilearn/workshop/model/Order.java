package org.simplilearn.workshop.model;

public class Order {


		private Orders orderDetails;
		private User user;
		private Product product;
		
		public Order() {
			super();
		}
		
		public Orders getOrderDetails() {
			return orderDetails;
		}
		
		public void setOrderDetails(Orders orderDetails) {
			this.orderDetails = orderDetails;
		}
		
		public User getUser() {
			return user;
		}
		
		public void setUser(User user) {
			this.user = user;
		}
		
		public Product getProduct() {
			return product;
		}
		
		public void setProduct(Product product) {
			this.product = product;
		}

		@Override
		public String toString() {
			return String.format("Order [orderDetails=%s, user=%s, product=%s]", orderDetails, user, product);
		}
		
		
		
}
