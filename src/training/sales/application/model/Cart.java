package training.sales.application.model;

/**
 * Represents a shopping cart item linking a user to a course.
 * Each Cart object corresponds to a course added by a user in their cart.
 */
public class Cart {
    
    private int id;
    private int idUser;
    private int idCourse;
    
    /**
     * Constructs a Cart item with the specified user ID and course ID.
     * The cart ID will typically be assigned by the database.
     *
     * @param idUser the ID of the user adding the course
     * @param idCourse the ID of the course being added
     */
    public Cart(int idUser, int idCourse) {
        this.idUser = idUser;
        this.idCourse = idCourse;
    }

    // getters and setters
    
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
