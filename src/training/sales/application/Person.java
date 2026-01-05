package training.sales.application;

public abstract class Person {
	private String lastname;
		private String firstname;
	
	public Person(String lastname, String firstname) {
		this.firstname = firstname;
		this.lastname = lastname;
		
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return getLastname() + " " + getFirstname();
	}
	
}
