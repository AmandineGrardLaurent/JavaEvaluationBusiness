package training.sales.application;

import java.util.List;


public class Main {
	
	
	public static void displayCourses(List<Course> courses, String title) {
		System.out.println(title);
		System.out.println("--------------------------\n");
	    for (Course course : courses) {
		            System.out.println(course);
		}
	    System.out.println(" ");
	}
	
	public static void main(String[] args) {

		// Display all courses
		displayCourses(Course.getAllCourses(), "La liste des formations : ");
	    
	    // Display courses on-site only
	    displayCourses(Course.getCoursesByType(true, false), "La liste des formations en présentiel : ");

	    
	    // Display courses online only
	    displayCourses(Course.getCoursesByType(false, true), "La liste des formations en ligne : ");

	    
	    // Display courses available in both types
	    displayCourses(Course.getCoursesByType(true, true), "La liste des formations disponibles en ligne et en présentiel : ");

	}
}
