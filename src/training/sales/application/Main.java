package training.sales.application;

import java.util.List;


public class Main {
	public static void main(String[] args) {

		// Display all courses
		System.out.println("---------------------------------- La liste des formations ----------------------------------\n");
		List<Course> courses = Course.getAllCourses();

	    for (Course course : courses) {
	            System.out.println(course);
	    }
	}
}
