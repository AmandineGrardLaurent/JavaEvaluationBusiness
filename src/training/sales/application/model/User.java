package training.sales.application.model;

public class User extends Person{
	private String password;
	private String login;
	private int id;
	
	public User(String lastname, String firstname, String password, String login) {
		super(lastname,  firstname);
		this.password = password;
		this.login = login;
	}
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public void setId(int id) {
		this.id = id;
	}
	
	
}
