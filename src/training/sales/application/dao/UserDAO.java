package training.sales.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import training.sales.application.model.User;

public class UserDAO {
	
	public User readByLoginPassword(String login, String password){
		User user = null;
        String sql = "SELECT lastname, firstname, id_user, user_.id_person, login, password "
        		+ "FROM user_ "
        		+ "JOIN person "
        		+ "ON user_.id_person = person.id_person "
        		+ "WHERE login = ? AND password = ?";

       try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql)){
            	 preparedStmt.setString(1, login);
            	 preparedStmt.setString(2, password);    
            	 
       try (ResultSet resultSet = preparedStmt.executeQuery()) {
 		            if (resultSet.next()) { 
 		            	int idUser = resultSet.getInt("id_user");
 		                String lastname = resultSet.getString("lastname");
 		                String firstname = resultSet.getString("firstname");

 		                user = new User(lastname, firstname, password, login);
 		                user.setId(idUser);
		            }
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	        return user;
	}
}
