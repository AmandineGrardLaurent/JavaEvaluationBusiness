package training.sales.application.model;

import java.util.Date;

public class Order {
	
	private int id;
	private Date orderDate;
	private double totalAmount;
	
	public Order(int id, Date orderDate, double totalAmount) {
		this.id = id;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
