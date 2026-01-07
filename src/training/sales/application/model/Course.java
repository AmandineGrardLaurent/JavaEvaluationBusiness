package training.sales.application.model;

/**
 * Represents a training course available in the application.
 * A course has a name, description, duration in days, type (on-site, online, or both),
 * and a price.
 */
public class Course {

    private int id;
    private String name;
    private String description;
    private int durationDays;
    private boolean isOnSite;
    private boolean isOnline;
    private double price;

    /**
     * Constructs a Course with the specified attributes.
     *
     * @param id the unique identifier of the course
     * @param name the name of the course
     * @param description a detailed description of the course
     * @param durationDays the duration of the course in days
     * @param isOnSite whether the course is available on-site
     * @param isOnline whether the course is available online
     * @param price the price of the course
     */
    public Course(int id, String name, String description, int durationDays, boolean isOnSite, boolean isOnline, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.durationDays = durationDays;
        this.isOnSite = isOnSite;
        this.isOnline = isOnline;
        this.price = price;
    }

    
    // Getters and setters
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	public boolean isOnSite() {
		return isOnSite;
	}

	public void setOnSite(boolean isOnSite) {
		this.isOnSite = isOnSite;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

    /**
     * Returns a formatted string representing the course in a table-like layout.
     * Includes course ID, name, description, duration, type, and price.
     *
     * @return a formatted string of the course
     */
    @Override
    public String toString() {
        int nameWidth = 30;
        int descriptionWidth = 65;
        int durationDaysWidth = 10;
        int typeWidth = 15;
        int priceWidth = 10;
        int idWidth = 3;

        String courseType = (isOnSite() && isOnline()) ? "mixte"
                : isOnline() ? "en ligne"
                : "en présentiel";

        return String.format("| %-" + idWidth + "s | %-" + nameWidth + "s | %-" + descriptionWidth + "s | %-" + durationDaysWidth + "s | %-" + typeWidth + "s | %-" + priceWidth + "s |",
                getId(),
                getName(),
                getDescription(),
                getDurationDays() + " jours",
                courseType,
                getPrice() + " €");
    }
}