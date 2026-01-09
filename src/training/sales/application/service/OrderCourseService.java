package training.sales.application.service;

import java.util.List;

import training.sales.application.dao.OrderCourseDAO;
import training.sales.application.model.Course;

public class OrderCourseService {
	
	private OrderCourseDAO orderCourseDao = new OrderCourseDAO();

    /**
     * Retrieves all orders associated with a given user ID.
     *
     * @param idUser the ID of the user
     * @return a list of Order objects for the specified user
     */
    public List<Course> getCourseByOrder(int idOrder) {
        return orderCourseDao.readCourseByOrder(idOrder);
    }
}
