package training.sales.application.model;

/**
 * Class representing a user of the system.
 * Extends the Person class and adds authentication-related information.
 */
public class User extends Person {

    private String password;
    private String login;
    private int id;

    /**
     * Constructs a User with the specified personal and login information.
     *
     * @param lastname  the user's last name
     * @param firstname the user's first name
     * @param password  the user's password
     * @param login     the user's login
     */
    public User(String lastname, String firstname, String password, String login) {
        super(lastname, firstname);
        this.password = password;
        this.login = login;
    }

    // Getters and setters

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
