package training.sales.application;

import java.util.List;

public class Course {
	
	private int id;
	private String name;
	private String description;
	private int durationDays;
	private boolean isPresential;
	private boolean isOnline;
	private double price;
	
	public Course(int id, String name, String description, int durationDays, boolean isPresential, boolean isOnline, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.durationDays = durationDays;
		this.isPresential = isPresential;
		this.isOnline = isOnline;
		this.price = price;
	}
	
	
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

	public boolean isPresential() {
		return isPresential;
	}

	public void setPresential(boolean isPresential) {
		this.isPresential = isPresential;
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
	
	static public List<Course> getAllCourses() {
		CourseDAO courseDao = new CourseDAO();
		return courseDao.readAll();
	}

	@Override
	public String toString() {
	    // Colmun width
	    int nameWidth = 30;
	    int descriptionWidth = 65;
	    int durationDaysWidth = 10;
	    int typeWidth = 15;
	    int priceWidth =10;

	    // Course type : presential or online or both
	    String courseType = (isPresential() && isOnline()) ? "mixte" 
	                  : isOnline() ? "en ligne" 
	                  : "présentiel";

	    // Result
	    return String.format("| %-"+nameWidth+"s | %-"+descriptionWidth+"s | %-"+durationDaysWidth+"s | %-"+typeWidth+"s | %-"+priceWidth+"s |",
	            getName(), 
	            getDescription(), 
	            getDurationDays() + " jours", 
	            courseType, 
	            getPrice() + " €");
	}
	
}
