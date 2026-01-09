package training.sales.application;

import java.util.List;
import java.util.Scanner;

import training.sales.application.model.Cart;
import training.sales.application.model.User;
import training.sales.application.service.CartService;
import training.sales.application.service.CourseService;
import training.sales.application.service.OrderService;
import training.sales.application.service.UserService;

/**
 * Main class of the training management application.
 * Handles displaying courses, user authentication, cart management,
 * and the menu for guests and connected users.
 */
public class Main {

    public static int askGuestChoice(Scanner scan) {
			System.out.println("[1] Afficher la liste de toutes les formations\n"
					+ "[2] Afficher les formations en présentiel\n"
					+ "[3] Afficher les formations en ligne\n"
					+ "[4] Afficher les formations mixtes\n"
					+ "[5] Rechercher les formations avec un mot-clé\n"
					+ "[6] Se connecter\n"
					+ "[7] Quitter\n");

			return Helper.askInt(scan, (Helper.ConsoleColors.BLUE + "Quel est votre choix ? " + Helper.ConsoleColors.RESET));
    }
    

    public static int askConnectedChoice(Scanner scan) {
			System.out.println("[1] Afficher la liste de toutes les formations\n"
					+ "[2] Afficher votre panier\n"
					+ "[3] Ajouter une formation dans votre panier\n"
					+ "[4] Supprimer une formation dans votre panier\n"
					+ "[5] Valider votre panier\n"
					+ "[6] Afficher mes commandes\n"
					+ "[7] Se déconnecter");

			return Helper.askInt(scan, (Helper.ConsoleColors.BLUE + "Quel est votre choix ? " + Helper.ConsoleColors.RESET));
    }


    /**
     * Application entry point.
     * Manages the main menu for guests, user login,
     * and the connected user menu with cart management.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        CourseService courseService = new CourseService();
        CartService cartService = new CartService();
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        
        Scanner scan = new Scanner(System.in);

        boolean runningMenu = true;

        while (runningMenu) {

            int choice = askGuestChoice(scan);
            switch (choice) {
		        case 1:
		        	Helper.displayItems(courseService.getAllCourses(), "La liste des formations : ", "Aucune formation trouvée");
		        	break;
		        case 2:
		        	Helper.displayItems(courseService.getCoursesByType(true, false), "La liste des formations en présentiel : ", "Aucune formation trouvée");
		            break;
		        case 3:
		        	Helper.displayItems(courseService.getCoursesByType(false, true), "La liste des formations en ligne : ", "Aucune formation trouvée");
		            break;
		        case 4:
		        	Helper.displayItems(courseService.getCoursesByType(true, true), "La liste des formations disponibles en ligne et en présentiel : ", "Aucune formation trouvée");
		            break;
		        case 5:
		            String keyword = Helper.askKeyword(scan);
		            Helper.displayItems(courseService.getCoursesByKeyword(keyword),
		                    String.format("La liste des formations correspondant au mot-clé %s : ", keyword), "Aucune formation trouvée avec votre mot-clé");
		            break;
                case 6:
                    User user = Helper.authenticateUser(scan, userService);
                    if (user == null) {
                        System.out.println("Login ou mot de passe incorrect.");
                        break;
                    }
                    System.out.println(Helper.ConsoleColors.GREEN + "Bonjour " + user + Helper.ConsoleColors.RESET);

                    boolean connected = true;
                    while (connected) {
                        int connectedChoice = askConnectedChoice(scan);
                        switch (connectedChoice) {
	                    case 1:
	                    	Helper.displayItems(courseService.getAllCourses(), "La liste des formations : ", "Aucune formation trouvée");
	                    	break;
	                    case 2:
	                    	Helper.displayItems(cartService.getCourseInCart(user.getId()), "Votre panier : ", "Votre panier est vide");
	                        break;
	                    case 3:
	                    	Helper.displayItems(courseService.getAllCourses(), "La liste des formations : ",  "Aucune formation trouvée");
	                    	int courseIdToAdd = Helper.askInt(scan, "Saisissez l'id de la formation que vous souhaitez ajouter : ");
                            Cart cart = new Cart(user.getId(), courseIdToAdd);
                            cartService.addCourseInCart(cart);
                            break;
	                    case 4:
	                    	Helper.displayItems(cartService.getCourseInCart(user.getId()), "Votre panier :",  "Votre panier est vide");
	                    	int courseIdToDelete = Helper.askInt(scan, "Saisissez l'id de la formation que vous souhaitez supprimer : ");
                            cartService.destroyCourseInCart(courseIdToDelete, user.getId());
	                        break;
	                    case 5:
	                        break;
	                    case 6:
	                    	Helper.displayItems(orderService.getOrderByUser(user.getId()), "Voici vos commandes : ", "Aucune commande trouvée");	                       
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
	            System.out.println(Helper.ConsoleColors.RED + "Option invalide, veuillez réessayer." + Helper.ConsoleColors.RESET);
            }
        }

        scan.close();
        System.out.println("Au revoir !");
    }
}
