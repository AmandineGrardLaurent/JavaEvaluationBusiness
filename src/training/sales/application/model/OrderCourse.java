package training.sales.application.model;

public class OrderCourse {
	private int idOrderCourse;
	private int idCourse;
	private int idOrder;
	
	public OrderCourse(int idCourse, int idOrder) {
		this.idCourse = idCourse;
		this.idOrder = idOrder;
	}

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
