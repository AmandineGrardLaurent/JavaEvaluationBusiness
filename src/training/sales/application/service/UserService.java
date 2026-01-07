package training.sales.application.service;

import training.sales.application.dao.UserDAO;
import training.sales.application.model.User;

/**
 * Service class for managing user-related operations.
 * Provides methods to authenticate users and retrieve user information.
 */
public class UserService {

    private UserDAO userDao = new UserDAO();

    /**
     * Retrieves a User by their login and password.
     * This is typically used for authentication purposes.
     *
     * @param login the user's login
     * @param password the user's password
     * @return a User object if credentials are correct, null otherwise
     */
    public User getUserByLoginPassword(String login, String password) {
        return userDao.readByLoginPassword(login, password);
    }
}
