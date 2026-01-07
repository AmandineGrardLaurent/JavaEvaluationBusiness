package training.sales.application.service;

import training.sales.application.dao.CartDAO;
import training.sales.application.model.Cart;

public class CartService {

	private CartDAO cartDao = new CartDAO();
	
	public void addCourseInCart(Cart cart) {	
		if (cartDao.create(cart)) {
			System.out.println("Formation ajoutée à votre panier");
		}
		else {
			System.out.println("Erreur lors de l'ajout de la formation dans le panier.");
		}
	}
}
