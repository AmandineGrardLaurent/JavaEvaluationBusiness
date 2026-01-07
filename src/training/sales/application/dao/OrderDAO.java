package training.sales.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import training.sales.application.model.Customer;
import training.sales.application.model.Order;

public class OrderDAO {
	public List<Order> readOrderByUser(int idUser) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT id_order, total_amount, order_date, order_.id_customer, id_user, person.lastname, person.firstname, address, email, phone_number "
                   + "FROM order_ "
                   + "JOIN customer "
                   + "ON order_.id_customer = customer.id_customer "
                   + "JOIN person "
                   + "ON person.id_person = customer.id_person "
                   + "WHERE id_user = ? ";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStmt = connection.prepareStatement(sql)) {
            
            preparedStmt.setInt(1, idUser);   
            
            try (ResultSet resultSet = preparedStmt.executeQuery()) {
                while (resultSet.next()) {
                    int idOrder = resultSet.getInt("id_order");
                    Double totalAmount = resultSet.getDouble("total_amount");
                    Date orderDate = resultSet.getDate("order_date");  
                    String lastname = resultSet.getString("lastname");
		            String firstname = resultSet.getString("firstname");
		            String address = resultSet.getString("address");
		            String email = resultSet.getString("email");
		            String phoneNumber = resultSet.getString("phone_number");
                    
		            Customer customer = new Customer(lastname, firstname, address, email, phoneNumber);
                    Order order = new Order(orderDate, totalAmount, idUser, customer);
                    order.setId(idOrder);
                    
                    orders.add(order);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
