package training.sales.application;

import java.util.List;
import java.util.Scanner;

import training.sales.application.model.Cart;
import training.sales.application.model.Course;
import training.sales.application.model.User;
import training.sales.application.service.CartService;
import training.sales.application.service.CourseService;
import training.sales.application.service.UserService;

/**
 * Main class of the training management application.
 * Handles displaying courses, user authentication, cart management,
 * and the menu for guests and connected users.
 */
public class Main {

    /**
     * Displays a list of courses with a title.
     *
     * @param courses The list of courses to display.
     * @param title   The title to display before the list.
     */
    public static void displayCourses(List<Course> courses, String title) {
        System.out.println(title);
        System.out.println("------------------------------------------------------------------------------------------\n");
        for (Course course : courses) {
            System.out.println(course);
        }
        System.out.println("\n");
    }

    /**
     * Displays the menu for guests and asks for a choice.
     *
     * @param scan Scanner for user input.
     * @return The option chosen by the user (integer).
     */
    public static int askGuestChoice(Scanner scan) {
        int number;
        while (true) {
            System.out.println("What is your choice?");
            System.out.println("[1] Display all courses\n"
                    + "[2] Display on-site courses\n"
                    + "[3] Display online courses\n"
                    + "[4] Display mixed courses\n"
                    + "[5] Search courses by keyword\n"
                    + "[6] Log in\n"
                    + "[7] Quit");

            if (!scan.hasNextInt()) {
                System.out.println("Please enter an integer.");
                scan.next();
                continue;
            }

            number = scan.nextInt();
            break;
        }
        return number;
    }

    /**
     * Displays the menu for a connected user and asks for a choice.
     *
     * @param scan Scanner for user input.
     * @return The option chosen by the user (integer).
     */
    public static int askConnectedChoice(Scanner scan) {
        int number;
        while (true) {
            System.out.println("What is your choice?");
            System.out.println("[1] Display all courses\n"
                    + "[2] Display your cart\n"
                    + "[3] Add a course to your cart\n"
                    + "[4] Remove a course from your cart\n"
                    + "[5] Validate your cart\n"
                    + "[6] Display my orders\n"
                    + "[7] Log out");

            if (!scan.hasNextInt()) {
                System.out.println("Please enter an integer.");
                scan.next();
                continue;
            }

            number = scan.nextInt();
            break;
        }
        return number;
    }

    /**
     * Asks the user for a keyword to search for courses.
     *
     * @param scan Scanner for user input.
     * @return The keyword entered, in lowercase and trimmed.
     */
    public static String askKeyword(Scanner scan) {
        System.out.println("Enter a keyword: ");
        return scan.next().toLowerCase().trim();
    }

    /**
     * Authenticates a user using login and password.
     *
     * @param scan        Scanner for user input.
     * @param userService Service handling user operations.
     * @return The authenticated user, or null if login/password is incorrect.
     */
    public static User authenticateUser(Scanner scan, UserService userService) {
        System.out.println("Enter your login: ");
        String login = scan.next();
        System.out.println("Enter your password: ");
        String password = scan.next();

        return userService.getUserByLoginPassword(login, password);
    }

    /**
     * Application entry point.
     * <p>
     * Manages the main menu for guests, user login,
     * and the connected user menu with cart management.
     * </p>
     *
     * @param args Command line arguments (not used).
     */
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
                    displayCourses(courseService.getAllCourses(), "List of courses:");
                    break;
                case 2:
                    displayCourses(courseService.getCoursesByType(true, false), "List of on-site courses:");
                    break;
                case 3:
                    displayCourses(courseService.getCoursesByType(false, true), "List of online courses:");
                    break;
                case 4:
                    displayCourses(courseService.getCoursesByType(true, true), "List of courses available online and on-site:");
                    break;
                case 5:
                    String keyword = askKeyword(scan);
                    displayCourses(courseService.getCoursesByKeyword(keyword),
                            String.format("List of courses matching keyword '%s': ", keyword));
                    break;
                case 6:
                    User user = authenticateUser(scan, userService);
                    if (user == null) {
                        System.out.println("Incorrect login or password.");
                        break;
                    }
                    System.out.println("Hello " + user);

                    boolean connected = true;
                    while (connected) {
                        int connectedChoice = askConnectedChoice(scan);
                        switch (connectedChoice) {
                            case 1:
                                displayCourses(courseService.getAllCourses(), "List of courses:");
                                break;
                            case 2:
                                displayCourses(cartService.getCourseInCart(user.getId()), "Your cart:");
                                break;
                            case 3:
                                displayCourses(courseService.getAllCourses(), "List of courses:");
                                System.out.println("Enter the ID of the course you want to add: ");
                                Cart cart = new Cart(user.getId(), scan.nextInt());
                                cartService.addCourseInCart(cart);
                                break;
                            case 4:
                                displayCourses(cartService.getCourseInCart(user.getId()), "Your cart:");
                                System.out.println("Enter the ID of the course you want to remove: ");
                                cartService.destroyCourseInCart(scan.nextInt(), user.getId());
                                break;
                            case 5:
                                // validate cart
                                break;
                            case 6:
                                // display orders
                                break;
                            case 7:
                                connected = false;
                                System.out.println("Logged out.");
                                break;
                        }
                    }
                    break;
                case 7:
                    runningMenu = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scan.close();
        System.out.println("Goodbye!");
    }
}
