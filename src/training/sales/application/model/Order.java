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
    private int idUser;
    private Customer customer;

    /**
     * Constructs an Order with the specified attributes.
     *
     * @param id the unique identifier of the order
     * @param orderDate the date when the order was placed
     * @param totalAmount the total monetary amount of the order
     */
    public Order(Date orderDate, double totalAmount, int idUser, Customer customer) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.idUser = idUser;
        this.customer = customer;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return ("======================== Commande n°" + this.id + " ========================"
				+ "\nDate : " + this.orderDate
				+ "\nTotal de la commande : " + this.totalAmount + "€"
				+ "\nBénéficiaire --------------------- " 
				+ "\nNom : " + customer.getFirstname() + " " + customer.getLastname()
				+ "\nEmail : " + customer.getEmail() 
				+ "\nAdresse : " + customer.getAddress() 
				+ "\nTel : " + customer.getPhoneNumber());
	}

}
