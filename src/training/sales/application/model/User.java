package training.sales.application.model;

public class User extends Person{
	private String password;
	
	public User(String lastname, String firstname, String password) {
		super(lastname,  firstname);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
