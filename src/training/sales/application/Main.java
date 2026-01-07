package training.sales.application;

import java.util.List;
import java.util.Scanner;

import training.sales.application.model.Cart;
import training.sales.application.model.Course;
import training.sales.application.model.Customer;
import training.sales.application.model.User;
import training.sales.application.service.CartService;
import training.sales.application.service.CourseService;
import training.sales.application.service.UserService;


public class Main {
	
	
	public static void displayCourses(List<Course> courses, String title) {
		System.out.println(title);
		System.out.println("--------------------------\n");
	    for (Course course : courses) {
		            System.out.println(course);
		}
	    System.out.println("\n");
	}
	
	public static int askGuestChoice(Scanner scan) {
		int number;
		
		while (true) {
			System.out.println("Quel est votre choix ? ");
			System.out.println("[1] Afficher la liste de toutes les formations\n"
					+ "[2] Afficher les formations en présentiel\n"
					+ "[3] Afficher les formations en ligne\n"
					+ "[4] Afficher les formations mixtes\n"
					+ "[5] Rechercher les formations avec un mot-clé\n"
					+ "[6] Me connecter\n"
					+ "[7] Quitter");
			
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
	
	public static int askConnectedChoice(Scanner scan) {
		int number;
		
		while (true) {
			System.out.println("Quel est votre choix ? ");
			System.out.println("[1] Afficher la liste de toutes les formations\n"
					+ "[2] Afficher votre panier\n"
					+ "[3] Ajouter une formation dans votre panier\n"
					+ "[4] Supprimer une formation dans votre panier\n"
					+ "[5] Valider votre panier\n"
					+ "[6] Afficher mes commandes\n"
					+ "[7] Se déconnecter");
			
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
	
	public static User authenticateUser(Scanner scan, UserService userService) {
		System.out.println("Quel est votre login ? ");
		String login = scan.next();
		System.out.println("Quel est votre mot de passe ? ");
		String password = scan.next();
		
		return userService.getUserByLoginPassword(login, password);
	}
	
	public static void main(String[] args) {
		
		CourseService courseService = new CourseService();
		CartService cartService = new CartService();
		UserService userService = new UserService();
		Scanner scan = new Scanner(System.in);
		
		boolean runningMenu = true;

		while (runningMenu) {

		    int choice = askGuestChoice(scan);
		    switch (choice) {
		        case 1:
		            displayCourses(courseService.getAllCourses(), "La liste des formations : ");
		            break;
		        case 2:
		            displayCourses(courseService.getCoursesByType(true, false), "La liste des formations en présentiel : ");
		            break;
		        case 3:
		            displayCourses(courseService.getCoursesByType(false, true), "La liste des formations en ligne : ");
		            break;
		        case 4:
		            displayCourses(courseService.getCoursesByType(true, true), "La liste des formations disponibles en ligne et en présentiel : ");
		            break;
		        case 5:
		            String keyword = askKeyword(scan);
		            displayCourses(courseService.getCoursesByKeyword(keyword),
		                    String.format("La liste des formations correspondant au mot-clé %s : ", keyword));
		            break;
		        case 6:
		            User user = authenticateUser(scan, userService);
		            if (user == null) {
		                System.out.println("Login ou mot de passe incorrect.");
		                break;
		            }
		            System.out.println("Bonjour " + user);

		            boolean connected = true;
		            while (connected) {
		                int connectedChoice = askConnectedChoice(scan);
		                switch (connectedChoice) {
		                    case 1:
		                        displayCourses(courseService.getAllCourses(), "La liste des formations : ");
		                        break;
		                    case 2:
		                        displayCourses(cartService.getCourseInCart(user.getId()), "Votre panier : ");
		                        break;
		                    case 3:
		                        Cart cart = new Cart(user.getId(), 5);
		                        cartService.addCourseInCart(cart);
		                        break;
		                    case 4:
		                        cartService.destroyCourseInCart(5, user.getId());
		                        break;
		                    case 5:
		                        break;
		                    case 6:
		                        break;
		                    case 7:
		                        connected = false;
		                        System.out.println("Déconnexion");
		                        break;
		                }
		            }
		            break;
		        case 7:
		            runningMenu = false;
		            break;
		        default:
		            System.out.println("Option invalide, veuillez réessayer.");
		    }
		}

		scan.close();
		System.out.println("Au revoir !");
	}
}
