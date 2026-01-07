package training.sales.application.model;

import java.util.Date;

/**
 * Represents an order in the application.
 * An order has an ID, a date, and a total amount.
 */
public class Order {

    private int id;
    private Date orderDate;
    private double totalAmount;

    /**
     * Constructs an Order with the specified attributes.
     *
     * @param id the unique identifier of the order
     * @param orderDate the date when the order was placed
     * @param totalAmount the total monetary amount of the order
     */
    public Order(int id, Date orderDate, double totalAmount) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters and setters

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
