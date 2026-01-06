package training.sales.application;

import java.util.List;
import java.util.Scanner;


public class Main {
	
	
	public static void displayCourses(List<Course> courses, String title) {
		System.out.println(title);
		System.out.println("--------------------------\n");
	    for (Course course : courses) {
		            System.out.println(course);
		}
	    System.out.println("\n");
	}
	
	public static int askChoice(Scanner scan) {
		int number;
		
		while (true) {
			System.out.println("Quel est votre choix ? ");
			System.out.println("[1] Afficher la liste de toutes les formations\n"
					+ "[2] Afficher les formations en présentiel\n"
					+ "[3] Afficher les formations en ligne\n"
					+ "[4] Afficher les formations mixtes\n"
					+ "[5] Rechercher les formations avec un mot-clé");
			
			// Check if the next token is an integer
			if (!scan.hasNextInt()) {
				System.out.println("Veuillez entrer un nombre entier.");
				scan.next();
				continue;
			}
			
			number = scan.nextInt();
			break;
		}
		return number;
	}
	
	public static String askKeyword(Scanner scan) {
		System.out.println("Saisissez le mot-clé : ");
		return scan.next().toLowerCase().trim();
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice = askChoice(scan);
		
		switch(choice) {
			case 1 : 
				// Display all courses
				displayCourses(Course.getAllCourses(), "La liste des formations : ");
			case 2 : 
				// Display courses on-site only
				displayCourses(Course.getCoursesByType(true, false), "La liste des formations en présentiel : ");
			case 3 : 	
				// Display courses online only
				displayCourses(Course.getCoursesByType(false, true), "La liste des formations en ligne : ");
			case 4 : 
			    // Display courses available in both types
			    displayCourses(Course.getCoursesByType(true, true), "La liste des formations disponibles en ligne et en présentiel : ");
			case 5 :
			    // Display courses contain a keyword
			    String keyword = askKeyword(scan);
			    displayCourses(Course.getCoursesByKeyword(keyword), String.format("La liste des formations correspondant au mot-clé %s : ", keyword));	
		}
	}
}
