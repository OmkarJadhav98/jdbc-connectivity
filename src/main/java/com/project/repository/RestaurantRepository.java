package com.project.repository;

import com.project.model.Restaurant;
import com.project.model.Contact;
import com.project.model.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestaurantRepository {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantRepository.class);
    private Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = JdbcConnection.getConnection();
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
                long contactId = resultSet.getLong("contact_id");

                // Fetch the contact for this restaurant
                Contact contact = new ContactRepository().findById(contactId);

                // Assuming Restaurant has a list of menus
                List<Menu> menus = new ArrayList<>();
                // You might want to retrieve the menu items for this restaurant
                // e.g., retrieveMenusByRestaurantId(restaurantId);

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
        return retrieveRestaurants();
    }

    public void createRestaurant(Restaurant restaurant) {
    }

    public void updateRestaurant(Restaurant restaurant) {
    }

    public void deleteRestaurant(long id) {
    }
}
