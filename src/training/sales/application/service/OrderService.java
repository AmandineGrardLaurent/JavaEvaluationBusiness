package training.sales.application.service;

import java.util.List;

import training.sales.application.dao.OrderDAO;
import training.sales.application.model.Order;

/**
 * Service class for managing order-related business logic.
 * Provides methods to retrieve orders for a specific user.
 * Acts as an intermediary between the DAO layer and the presentation layer.
 */
public class OrderService {

    private OrderDAO orderDao = new OrderDAO();

    /**
     * Retrieves all orders associated with a given user ID.
     *
     * @param idUser the ID of the user
     * @return a list of Order objects for the specified user
     */
    public List<Order> getOrderByUser(int idUser) {
        return orderDao.readOrderByUser(idUser);
    }
}
