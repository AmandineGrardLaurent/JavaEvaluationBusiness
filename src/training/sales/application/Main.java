package training.sales.application;

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

    /**
     * Displays the guest menu and asks the user to choose an option.
     *
     * @param scan the Scanner used to read user input
     * @return the chosen menu option as an integer
     */
    public static int askGuestChoice(Scanner scan) {
        System.out.println("Menu visiteur : \n"
        		+ "[1] Afficher la liste de toutes les formations\n"
                + "[2] Afficher les formations en présentiel\n"
                + "[3] Afficher les formations en ligne\n"
                + "[4] Afficher les formations mixtes\n"
                + "[5] Rechercher les formations avec un mot-clé\n"
                + "[6] Se connecter\n"
                + "[7] Quitter\n");
        
        // Ask the user for a numeric choice
        return Helper.askInt(
                scan,
                Helper.ConsoleColors.BLUE + "Quel est votre choix ? " + Helper.ConsoleColors.RESET
        );
    }
    

    /**
     * Displays the menu for a connected user and asks for an option.
     *
     * @param scan the Scanner used to read user input
     * @return the chosen menu option as an integer
     */
    public static int askConnectedChoice(Scanner scan) {
        System.out.println("Menu utilisateur connecté : \n"
        		+ "[1] Afficher la liste de toutes les formations\n"
                + "[2] Afficher votre panier\n"
                + "[3] Ajouter une formation dans votre panier\n"
                + "[4] Supprimer une formation dans votre panier\n"
                + "[5] Valider votre panier\n"
                + "[6] Afficher mes commandes\n"
                + "[7] Se déconnecter");
        
     // Ask the user for a numeric choice
        return Helper.askInt(
                scan,
                Helper.ConsoleColors.BLUE + "Quel est votre choix ? " + Helper.ConsoleColors.RESET
        );
    }
    

    /**
     * Application entry point.
     * Manages the main menu for guests, user authentication,
     * and connected user actions such as cart and order management.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

    	// Initialize services
        CourseService courseService = new CourseService();
        CartService cartService = new CartService();
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        Scanner scan = new Scanner(System.in);
        boolean runningMenu = true;

        // Main loop for the non connected menu (guest)
        while (runningMenu) {

            int choice = askGuestChoice(scan);
            switch (choice) {
            	// Show all courses
                case 1:
                    Helper.displayItems(
                            courseService.getAllCourses(),
                            "La liste des formations : ",
                            "Aucune formation trouvée"
                    );
                    break;
                    
                // Show on site courses
                case 2:
                    Helper.displayItems(
                            courseService.getCoursesByType(true, false),
                            "La liste des formations en présentiel : ",
                            "Aucune formation trouvée"
                    );
                    break;
                    
                // Show onlin courses
                case 3:
                    Helper.displayItems(
                            courseService.getCoursesByType(false, true),
                            "La liste des formations en ligne : ",
                            "Aucune formation trouvée"
                    );
                    break;
                    
                // Show mixed courses
                case 4:
                    Helper.displayItems(
                            courseService.getCoursesByType(true, true),
                            "La liste des formations disponibles en ligne et en présentiel : ",
                            "Aucune formation trouvée"
                    );
                    break;
                
                // Search courses by keyword
                case 5:
                    String keyword = Helper.askKeyword(scan);
                    Helper.displayItems(
                            courseService.getCoursesByKeyword(keyword),
                            String.format("La liste des formations correspondant au mot-clé %s : ", keyword),
                            "Aucune formation trouvée avec votre mot-clé"
                    );
                    break;
                    
                // User login
                case 6:
                    User user = Helper.authenticateUser(scan, userService);
                    if (user == null) {
                        System.out.println("Login ou mot de passe incorrect");
                        break;
                    }

                    System.out.println(
                            Helper.ConsoleColors.GREEN + "Bonjour " + user + Helper.ConsoleColors.RESET
                    );

                    boolean connected = true;
                    
                    // Loop for connected user menu
                    while (connected) {
                        int connectedChoice = askConnectedChoice(scan);
                        switch (connectedChoice) {
                        	
                        	// Show all courses
                            case 1:
                                Helper.displayItems(
                                        courseService.getAllCourses(),
                                        "La liste des formations : ",
                                        "Aucune formation trouvée"
                                );
                                break;
                                
                            // Show courses in the user's cart
                            case 2:
                                Helper.displayItems(
                                        cartService.getCourseInCart(user.getId()),
                                        "Votre panier : ",
                                        "Votre panier est vide"
                                );
                                break;
                                
                            // Add a course to the cart
                            case 3:
                                Helper.displayItems(
                                        courseService.getAllCourses(),
                                        "La liste des formations : ",
                                        "Aucune formation trouvée"
                                );
                                
                                // Ask the user to enter a valid idCourse to add
                                int courseIdToAdd = Helper.askIdCourse(
                                		scan, 
                                		courseService, 
                                		"Saisissez l'id de la formation que vous souhaitez ajouter : ");
                                
                                Cart cart = new Cart(user.getId(), courseIdToAdd);
                                cartService.addCourseInCart(cart);

                                break;
                            
                            // Delete a course from the cart
                            case 4:
                                Helper.displayItems(
                                        cartService.getCourseInCart(user.getId()),
                                        "Votre panier :",
                                        "Votre panier est vide"
                                );
                                
                                // Ask the user to enter a valid idCourse to delete
                                int courseIdToDelete = Helper.askIdCourse(
                                        scan, courseService,
                                        "Saisissez l'id de la formation que vous souhaitez supprimer : "
                                );
                                
                                cartService.destroyCourseInCart(courseIdToDelete, user.getId());
                                break;
                            case 5:
                            	// to do : implement cart validation and order creation
                                break;
                                
                            // Show user orders
                            case 6:
                                Helper.displayItems(
                                        orderService.getOrderWithCoursesByUser(user.getId()),
                                        "Voici vos commandes : ",
                                        "Aucune commande trouvée"
                                );
                                break;
                                
                            // Logout
                            case 7:
                                connected = false;
                                System.out.println("Déconnexion");
                                break;
                        }
                    }
                    break;
                // Exit application
                case 7:
                    runningMenu = false;
                    break;
                default:
                    System.out.println(
                            Helper.ConsoleColors.RED +
                            "Option invalide, veuillez réessayer." +
                            Helper.ConsoleColors.RESET
                    );
            }
        }
        scan.close();
        System.out.println("Au revoir !");
    }
}
