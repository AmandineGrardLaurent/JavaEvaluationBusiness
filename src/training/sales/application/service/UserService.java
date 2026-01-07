package training.sales.application.service;

import training.sales.application.dao.UserDAO;
import training.sales.application.model.User;


public class UserService {
	private UserDAO userDao = new UserDAO();
	
	public User getUserByLoginPassword(String login, String password){
		return userDao.readByLoginPassword(login, password);
	}
}
