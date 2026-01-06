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
        String sql = "SELECT id_course, name, description, duration_days, is_on_site, is_online, price FROM Course";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStmt.executeQuery()) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }
	
	public List<Course> readAllByType(boolean onSite, boolean online){
		List<Course> courses = new ArrayList<>();
        String sql = "SELECT id_course, name, description, duration_days, is_on_site, is_online, price FROM Course WHERE is_on_site = ? AND is_online = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql)){
            	 preparedStmt.setBoolean(1, onSite);
            	 preparedStmt.setBoolean(2, online);    
        		
        try (ResultSet resultSet = preparedStmt.executeQuery()){

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
	
	public List<Course> readAllByKeyword(String keyword){
		List<Course> courses = new ArrayList<>();
        String sql = "SELECT id_course, name, description, duration_days, is_on_site, is_online, price FROM Course WHERE name LIKE ? OR description LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql)){
            	 preparedStmt.setString(1, "%" + keyword + "%");
            	 preparedStmt.setString(2, "%" + keyword + "%");
        		
        try (ResultSet resultSet = preparedStmt.executeQuery()){

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
	
}
