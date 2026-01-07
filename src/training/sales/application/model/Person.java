package training.sales.application.model;

/**
 * Abstract class representing a person.
 * Contains basic personal information such as first name and last name.
 */
public abstract class Person {

    private String lastname;
    private String firstname;

    /**
     * Constructs a Person with the specified last name and first name.
     *
     * @param lastname  the last name of the person
     * @param firstname the first name of the person
     */
    public Person(String lastname, String firstname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getters and setters omitted for brevity

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

    /**
     * Returns the full name of the person in the format "Lastname Firstname".
     *
     * @return the full name
     */
    @Override
    public String toString() {
        return getLastname() + " " + getFirstname();
    }
}
