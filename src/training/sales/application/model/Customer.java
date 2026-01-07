package training.sales.application.model;

public class Customer extends Person{
	
	private String address;
	private String email;
	private String phoneNumber;
	
	public Customer(String lastname, String firstname, String address, String email, String phoneNumber) {
		super(lastname, firstname);
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

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

	@Override
	public String toString() {
		return "Informations du client : "
				+ "\nNom : " + super.getLastname()
				+ "\nPrénom : " + super.getFirstname()
				+ "\nAdresse : " + this.address 
				+ "\nEmail : " + this.email
				+ "\nTel : " + this.phoneNumber;
	}
	
	
}
