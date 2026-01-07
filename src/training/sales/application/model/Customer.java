package training.sales.application.model;

/**
 * Represents a customer in the application.
 * A customer is a person with contact information such as address, email, and phone number.
 */
public class Customer extends Person {

    private String address;
    private String email;
    private String phoneNumber;

    /**
     * Constructs a Customer with the specified attributes.
     *
     * @param lastname the last name of the customer
     * @param firstname the first name of the customer
     * @param address the postal address of the customer
     * @param email the email address of the customer
     * @param phoneNumber the phone number of the customer
     */
    public Customer(String lastname, String firstname, String address, String email, String phoneNumber) {
        super(lastname, firstname);
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	 /**
     * Returns a string representation of the customer, including personal and contact information.
     *
     * @return a formatted string with the customer's details
     */
    @Override
    public String toString() {
        return "Customer Information: "
                + "\nLast Name: " + super.getLastname()
                + "\nFirst Name: " + super.getFirstname()
                + "\nAddress: " + this.address 
                + "\nEmail: " + this.email
                + "\nPhone: " + this.phoneNumber;
    }
}