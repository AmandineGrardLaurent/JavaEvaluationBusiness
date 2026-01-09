package training.sales.application;

import java.util.List;
import java.util.Scanner;

import training.sales.application.model.User;
import training.sales.application.service.UserService;

/**
 * Utility class providing helper methods for the application.
 * This class centralizes common console interactions such as
 * displaying lists, reading user input, and authenticating users.
 */
public class Helper {

    /**
     * Utility class defining ANSI escape codes for colored console output.
     * These constants can be used to improve readability in the terminal.
     */
    public class ConsoleColors {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
    }

    /**
     * Displays a list of items in the console with a title.
     * If the list is empty, an alternative message is displayed instead.
     *
     * @param <T>          the type of elements in the list
     * @param items        the list of items to display
     * @param title        the title displayed above the list
     * @param errorMessage the message displayed if the list is empty
     */
    public static <T> void displayItems(List<T> items, String title, String errorMessage) {
        if (items.isEmpty()) {
            System.out.println(ConsoleColors.RED + errorMessage + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE + title + ConsoleColors.RESET + "\n");
            for (T item : items) {
                System.out.println(item);
            }
            System.out.println("\n");
        }
    }

    /**
     * Asks the user to enter an integer value.
     * The method keeps prompting until a valid integer is provided.
     *
     * @param scan    the Scanner used to read user input
     * @param message the message displayed to prompt the user
     * @return the integer entered by the user
     */
    public static int askInt(Scanner scan, String message) {
        int number;
        while (true) {
            System.out.println(message);
            if (!scan.hasNextInt()) {
                System.out.println(ConsoleColors.RED + "Saisissez un entier." + ConsoleColors.RESET);
                scan.next();
                continue;
            }
            number = scan.nextInt();
            break;
        }
        return number;
    }

    /**
     * Prompts the user to enter a keyword for searching courses.
     *
     * @param scan the Scanner used to read user input
     * @return the keyword entered by the user, in lowercase and trimmed
     */
    public static String askKeyword(Scanner scan) {
        System.out.println("Saisissez un mot-clé : ");
        return scan.next().toLowerCase().trim();
    }

    /**
     * Authenticates a user by asking for login and password,
     * then delegating the verification to the UserService.
     *
     * @param scan        the Scanner used to read user input
     * @param userService the service responsible for user authentication
     * @return the authenticated User, or null if authentication fails
     */
    public static User authenticateUser(Scanner scan, UserService userService) {
        System.out.println("Quel est votre login ? ");
        String login = scan.next();
        System.out.println("Quel est votre mot de passe ? ");
        String password = scan.next();

        return userService.getUserByLoginPassword(login, password);
    }
}
