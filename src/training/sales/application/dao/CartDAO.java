package training.sales.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import training.sales.application.model.Cart;
import training.sales.application.model.Course;

/**
 * Data Access Object (DAO) for managing operations on the Cart table.
 * Provides methods to add, retrieve, and delete courses in a user's cart.
 */
public class CartDAO {
    
    /**
     * Adds a course to the cart for a given user.
     *
     * @param cart : the Cart object containing idUser and idCourse
     * @return true if the course was successfully added, false otherwise
     */
    public boolean addCourse(Cart cart) {
        String sql = "INSERT INTO Cart(id_user, id_course) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            preparedStmt.setInt(1, cart.getIdUser());
            preparedStmt.setInt(2, cart.getIdCourse());

            int affectedRows = preparedStmt.executeUpdate();

            if (affectedRows == 0) {
                System.out.println("Failed to add course to cart.");
                return false;
            }
            
            try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    cart.setId(id);
                }
            }

            return true;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Retrieves all courses in a user's cart.
     *
     * @param idUser : the ID of the user
     * @return a list of Course objects currently in the user's cart
     */
    public List<Course> getCourseByUser(int idUser) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT co.id_course, name, description, duration_days, is_on_site, is_online, price, ca.id_user "
                   + "FROM course AS co "
                   + "JOIN cart AS ca "
                   + "ON ca.id_course = co.id_course "
                   + "WHERE ca.id_user = ? ";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql)) {
            
            preparedStmt.setInt(1, idUser);   
            
            try (ResultSet resultSet = preparedStmt.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_course");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int durationDays = resultSet.getInt("duration_days");
                    boolean isOnSite = resultSet.getBoolean("is_on_site");
                    boolean isOnline = resultSet.getBoolean("is_online");        
                    double price = resultSet.getDouble("price");

                    Course course = new Course(id, name, description, durationDays, isOnSite, isOnline, price);
                    courses.add(course);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }
    
    /**
     * Deletes a course from a user's cart.
     *
     * @param idCourse : the ID of the course to remove
     * @param idUser : the ID of the user whose cart will be modified
     * @return true if the course was successfully deleted, false otherwise
     */
    public boolean deleteCourse(int idCourse, int idUser) {
        String sql = "DELETE FROM cart WHERE id_course = ? AND id_user = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql)) {
            
            preparedStmt.setInt(1, idCourse);
            preparedStmt.setInt(2, idUser);
            
            int deletedRows = preparedStmt.executeUpdate();
            
            return deletedRows > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
