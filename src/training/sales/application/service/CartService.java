package training.sales.application.service;

import java.util.List;

import training.sales.application.dao.CartDAO;
import training.sales.application.model.Cart;
import training.sales.application.model.Course;

public class CartService {

	private CartDAO cartDao = new CartDAO();
	
	public void addCourseInCart(Cart cart) {	
		if (cartDao.addCourse(cart)) {
			System.out.println("Formation ajoutée à votre panier");
		}
		else {
			System.out.println("Erreur lors de l'ajout de la formation dans le panier.");
		}
	}
	
	public List<Course> getCourseInCart(int idUser) {	
		return cartDao.getCourseByUser(idUser);
	}
	
	public void destroyCourseInCart(int idCourse, int idUser) {
		if (cartDao.deleteCourse(idCourse, idUser)) {
			System.out.println("Formation supprimée");
		}
		else{
			System.out.println("Erreur lors de la suppression de la formation.");
		};
	}
}
