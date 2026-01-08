	package training.sales.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import training.sales.application.model.Course;

public class OrderCourseDAO {
	public List<Course> readCourseByOrder(int idOrder) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT oc.id_course, name, description, duration_days, is_on_site, is_online, price, oc.id_order "
        		+ "FROM Course "
        		+ "JOIN order_course AS oc "
        		+ "ON oc.id_course = course.id_course "
        		+ "JOIN order_ "
        		+ "ON order_.id_order = oc.id_order "
        		+ "WHERE oc.id_order = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql)) {

            preparedStmt.setInt(1, idOrder);
        
        		
            try (ResultSet resultSet = preparedStmt.executeQuery()) {
                while (resultSet.next()) {
                    int idCourse = resultSet.getInt("oc.id_course");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int durationDays = resultSet.getInt("duration_days");
                    boolean isOnSite = resultSet.getBoolean("is_on_site");
                    boolean isOnline = resultSet.getBoolean("is_online");		
                    double price = resultSet.getDouble("price");

                    Course course = new Course(idCourse, name, description, durationDays, isOnSite, isOnline, price);
                    courses.add(course);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }
}
