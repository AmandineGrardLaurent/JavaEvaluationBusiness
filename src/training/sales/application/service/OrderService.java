package training.sales.application.service;

import java.util.List;

import training.sales.application.dao.OrderDAO;
import training.sales.application.model.Order;


public class OrderService {
	private OrderDAO orderDao = new OrderDAO();
	
	public List<Order> getOrderByUser(int idUser) {
        return orderDao.readOrderByUser(idUser);
    }
}
