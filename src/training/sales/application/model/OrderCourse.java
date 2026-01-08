package training.sales.application.model;

/**
 * Represents the association between an Order and a Course.
 * Each instance links a specific course to a specific order.
 * This class is used to map the courses contained in an order.
 */
public class OrderCourse {

    private int idOrderCourse;
    private int idCourse;
    private int idOrder;

    /**
     * Constructs an OrderCourse linking a course to an order.
     *
     * @param idCourse the ID of the course
     * @param idOrder the ID of the order
     */
    public OrderCourse(int idCourse, int idOrder) {
        this.idCourse = idCourse;
        this.idOrder = idOrder;
    }
    
    // Getters and setters

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdOrderCourse() {
        return idOrderCourse;
    }

    public void setIdOrderCourse(int idOrderCourse) {
        this.idOrderCourse = idOrderCourse;
    }
}
