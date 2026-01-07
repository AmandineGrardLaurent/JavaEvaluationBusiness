package training.sales.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import training.sales.application.model.Cart;



public class CartDAO {
	
	public boolean create(Cart cart) {
		String sql = "INSERT INTO Cart(id_user, id_course) VALUES (?, ?)";
		try (Connection connection = DatabaseConnection.getConnection();
		         PreparedStatement preparedStmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			preparedStmt.setInt(1, cart.getIdUser());
			preparedStmt.setInt(2, cart.getIdCourse());

		   int affectedRows = preparedStmt.executeUpdate();

		   if (affectedRows == 0) {
		        System.out.println("L'ajout de la formation dans le panier a échoué.");
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
}
