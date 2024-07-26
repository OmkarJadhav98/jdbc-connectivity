package com.project.repository;

import com.project.model.Restaurant;
import com.project.model.Contact;
import com.project.model.Menu;
import com.project.service.ConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantRepository.class);
    private Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionService.getConnection();
        }
    }

    public Restaurant findById(long restaurantId) {
        String query = "SELECT * FROM restaurant WHERE id = ?";
        Restaurant restaurant = null;
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, restaurantId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                long contactId = resultSet.getLong("contact_id"); // Changed to long to match ID type

                // Fetch the contact for this restaurant
                Contact contact = new ContactRepository().findById(contactId);

                // Retrieve the menu items for this restaurant
                List<Menu> menus = retrieveMenusByRestaurantId(id);

                restaurant = new Restaurant(id, name, contact, menus);
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
        return restaurant;
    }

    public List<Restaurant> retrieveRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurant";

        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                long contactId = resultSet.getLong("contact_id"); // Changed to long to match ID type

                // Fetch the contact for this restaurant
                Contact contact = new ContactRepository().findById(contactId);

                // Retrieve the menu items for this restaurant
                List<Menu> menus = retrieveMenusByRestaurantId(id);

                Restaurant restaurant = new Restaurant(id, name, contact, menus);
                restaurants.add(restaurant);
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
        return restaurants;
    }

    public void createRestaurant(Restaurant restaurant) {
        String query = "INSERT INTO restaurant (name, contact_id) VALUES (?, ?)";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setLong(2, restaurant.getContact().getId()); // Ensure getId() is in Contact
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

    public void updateRestaurant(Restaurant restaurant) {
        String query = "UPDATE restaurant SET name = ?, contact_id = ? WHERE id = ?";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setLong(2, restaurant.getContact().getId()); // Ensure getId() is in Contact
            preparedStatement.setLong(3, restaurant.getId()); // Ensure getId() is in Restaurant
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

    public void deleteRestaurant(long id) {
        String query = "DELETE FROM restaurant WHERE id = ?";
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

    private List<Menu> retrieveMenusByRestaurantId(long restaurantId) {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE restaurant_id = ?";

        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, restaurantId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long menuId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                boolean availability = resultSet.getBoolean("availability");

                Menu menu = new Menu(menuId, name, description, price, null, availability); // Set restaurant as null initially
                menus.add(menu);
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
        return menus;
    }
}
