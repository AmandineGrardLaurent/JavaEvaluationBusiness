package training.sales.application;

public class Course {
	
	private String name;
	private String description;
	private int durationDays;
	private boolean isPresential;
	private boolean isOnline;
	private float price;
	
	public Course(String name, String description, int durationDays, boolean isPresential, boolean isOnline, float price) {
		this.name = name;
		this.description = description;
		this.durationDays = durationDays;
		this.isPresential = isPresential;
		this.isOnline = isOnline;
		this.price = price;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "| " + getName() + " | " 
				+ getDescription() + " | " 
				+ getDurationDays() + " jours | "
				+ (isPresential() && isOnline() ? "mixte" : isOnline()? "en ligne" : "présentiel") + " | "
				+ getPrice() + " €";
	}
	
}
