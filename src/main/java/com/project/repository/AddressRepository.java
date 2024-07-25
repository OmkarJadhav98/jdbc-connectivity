package com.project.repository;

import com.project.model.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressRepository {

    private static final Logger logger = LoggerFactory.getLogger(AddressRepository.class);
    private Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = JdbcConnection.getConnection();
        }
    }

    public List<Address> retrieveAddresses() {
        List<Address> addresses = new ArrayList<>();
        String query = "SELECT * FROM address";

        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                long flatNo = resultSet.getLong("flatNo");
                String buildingName = resultSet.getString("buildingName");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                long pinCode = resultSet.getLong("pinCode");

                Address address = new Address(id, name, flatNo, buildingName, street, city, state, pinCode);
                addresses.add(address);
            }
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        }
        return addresses;
    }

    public void createAddress(Address address) {
        String query = "INSERT INTO address (id, name, flatNo, buildingName, street, city, state, pinCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getName());
            preparedStatement.setLong(3, address.getFlatNo());
            preparedStatement.setString(4, address.getBuildingName());
            preparedStatement.setString(5, address.getStreet());
            preparedStatement.setString(6, address.getCity());
            preparedStatement.setString(7, address.getState());
            preparedStatement.setLong(8, address.getPinCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        }
    }

    public void updateAddress(Address address) {
        String query = "UPDATE address SET id = ?, name = ?, flatNo = ?, buildingName = ?, street = ?, city = ?, state = ?, pinCode = ? WHERE id = ?";
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getName());
            preparedStatement.setLong(3, address.getFlatNo());
            preparedStatement.setString(4, address.getBuildingName());
            preparedStatement.setString(5, address.getStreet());
            preparedStatement.setString(6, address.getCity());
            preparedStatement.setString(7, address.getState());
            preparedStatement.setLong(8, address.getPinCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        }
    }

    public void deleteAddress(long id) {
        String query = "DELETE FROM address WHERE id = ?";
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        }
    }

    public Address findById(long addressId) {
        String query = "SELECT * FROM address WHERE id = ?";
        Address address = null;
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setLong(1, addressId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    long flatNo = resultSet.getLong("flatNo");
                    String buildingName = resultSet.getString("buildingName");
                    String street = resultSet.getString("street");
                    String city = resultSet.getString("city");
                    String state = resultSet.getString("state");
                    long pinCode = resultSet.getLong("pinCode");

                    address = new Address(id, name, flatNo, buildingName, street, city, state, pinCode);
                }
            }
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        }
        return address;
    }
}