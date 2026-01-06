package training.sales.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CourseDAO {

	public List<Course> readAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStmt.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_course");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int durationDays = resultSet.getInt("duration_days");
                boolean isPresential = resultSet.getBoolean("is_presential");
                boolean isOnline = resultSet.getBoolean("is_online");		
                double price = resultSet.getDouble("price");

                Course course = new Course(id, name, description, durationDays, isPresential, isOnline, price);
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }
}
