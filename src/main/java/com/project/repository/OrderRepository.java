package com.project.repository;

import com.project.model.Order;
import com.project.model.Customer;
import com.project.model.DeliveryExecutive;
import com.project.model.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    private Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = JdbcConnection.getConnection();
        }
    }

    public List<Order> retrieveOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";

        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long customerId = resultSet.getLong("customer_id");
                long menuId = resultSet.getLong("menu_id");
                long deliveryExecutiveId = resultSet.getLong("delivery_executive_id");
                Timestamp timestamp = resultSet.getTimestamp("timestamp");

                Customer customer = new CustomerRepository().findById(customerId);
                Menu menu = new MenuRepository().findById(menuId);
                DeliveryExecutive deliveryExecutive = new DeliveryExecutiveRepository().findById(deliveryExecutiveId);

                Order order = new Order(id, customer, menu, deliveryExecutive, timestamp.toLocalDateTime());
                orders.add(order);
            }
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
        return orders;
    }

    public void createOrder(Order order) {
        String query = "INSERT INTO orders (customer_id, menu_id, delivery_executive_id, timestamp) VALUES (?, ?, ?, ?)";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, order.getCustomer().getId());
            preparedStatement.setLong(2, order.getMenu().getId());
            preparedStatement.setLong(3, order.getDeliveryExecutive().getId());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(order.getTimestamp()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
    }

    public void updateOrder(Order order) {
        String query = "UPDATE orders SET customer_id = ?, menu_id = ?, delivery_executive_id = ?, timestamp = ? WHERE id = ?";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, order.getCustomer().getId());
            preparedStatement.setLong(2, order.getMenu().getId());
            preparedStatement.setLong(3, order.getDeliveryExecutive().getId());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(order.getTimestamp()));
            preparedStatement.setLong(5, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
    }

    public void deleteOrder(long id) {
        String query = "DELETE FROM orders WHERE id = ?";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
    }

    public Order findById(long id) {
        return null;
    }
}
