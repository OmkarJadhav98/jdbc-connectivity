package com.project.repository;

import com.project.model.Menu;
import com.project.model.Restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuRepository {

    private static final Logger logger = LoggerFactory.getLogger(MenuRepository.class);
    private Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = JdbcConnection.getConnection();
        }
    }

    public Menu findById(long menuId) {
        String query = "SELECT * FROM menu WHERE id = ?";
        Menu menu = null;
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, menuId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                long restaurantId = resultSet.getLong("restaurant_id");
                String state = resultSet.getString("state");
                boolean availability = resultSet.getBoolean("availability"); // Assuming you have an 'availability' field in the table

                // Fetch the restaurant for this menu item
                Restaurant restaurant = new RestaurantRepository().findById(restaurantId);

                menu = new Menu(id, name, description, price, restaurant, state);
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
        return menu;
    }

    public void createMenu(Menu menu) {
        String query = "INSERT INTO menu (name, description, price, restaurant_id, state, availability) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, menu.getName());
            preparedStatement.setString(2, menu.getDescription());
            preparedStatement.setDouble(3, menu.getPrice());
            preparedStatement.setLong(4, menu.getRestaurant().getId()); // Ensure Restaurant has an ID
            preparedStatement.setString(5, menu.getState());
            preparedStatement.setBoolean(6, menu.isAvailability()); // Ensure you have a getter for 'availability'
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

    public void updateMenu(Menu menu) {
        String query = "UPDATE menu SET name = ?, description = ?, price = ?, restaurant_id = ?, state = ?, availability = ? WHERE id = ?";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, menu.getName());
            preparedStatement.setString(2, menu.getDescription());
            preparedStatement.setDouble(3, menu.getPrice());
            preparedStatement.setLong(4, menu.getRestaurant().getId()); // Ensure Restaurant has an ID
            preparedStatement.setString(5, menu.getState());
            preparedStatement.setBoolean(6, menu.isAvailability()); // Ensure you have a getter for 'availability'
            preparedStatement.setLong(7, menu.getId());
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

    public void deleteMenu(long id) {
        String query = "DELETE FROM menu WHERE id = ?";
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

    public List<Menu> retrieveMenus() {
        return retrieveMenus();
    }
}
