package training.sales.application.model;

public class Cart {
	private int id;
	private int idUser;
	private int idCourse;
	
	public Cart(int idUser, int idCourse) {
		this.idUser = idUser;
		this.idCourse = idCourse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	
}
