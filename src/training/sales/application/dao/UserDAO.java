package training.sales.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import training.sales.application.model.User;

/**
 * Data Access Object (DAO) for the User entity.
 * 
 * Provides methods to interact with the database for user-related operations,
 * such as retrieving a user by their login and password.
 */
public class UserDAO {
	
    /**
     * Retrieves a User from the database by login and password.
     *
     * This method performs a JOIN between the `user_` and `person` tables
     * to obtain the full name and user ID.
     *
     * @param login the login of the user
     * @param password the password of the user
     * @return a User object if the credentials match, or null if no user is found
     */
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
