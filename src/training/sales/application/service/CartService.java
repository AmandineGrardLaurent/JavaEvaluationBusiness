package training.sales.application.service;

import java.util.List;

import training.sales.application.dao.CartDAO;
import training.sales.application.model.Cart;
import training.sales.application.model.Course;

/**
 * Service class for managing operations on a user's cart.
 * Provides methods to add, remove, and retrieve courses in the cart.
 */
public class CartService {

    private CartDAO cartDao = new CartDAO();

    /**
     * Adds a course to the user's cart.
     *
     * @param cart the Cart object containing the user ID and course ID
     */
    public void addCourseInCart(Cart cart) {
        if (cartDao.addCourse(cart)) {
            System.out.println("Formation ajoutée à votre panier");
        } else {
            System.out.println("Erreur lors de l'ajout de la formation dans le panier.");
        }
    }

    /**
     * Retrieves all courses in the cart for a given user.
     *
     * @param idUser the ID of the user
     * @return a list of Course objects in the user's cart
     */
    public List<Course> getCourseInCart(int idUser) {
        return cartDao.getCourseByUser(idUser);
    }

    /**
     * Removes a course from a user's cart.
     *
     * @param idCourse the ID of the course to remove
     * @param idUser   the ID of the user
     */
    public void destroyCourseInCart(int idCourse, int idUser) {
        if (cartDao.deleteCourse(idCourse, idUser)) {
            System.out.println("Formation supprimée");
        } else {
            System.out.println("Erreur lors de la suppression de la formation.");
        }
    }
}
