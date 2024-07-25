package com.project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcConnection {

    private static final Logger logger = LoggerFactory.getLogger(JdbcConnection.class);
    private static final String URL = "jdbc:mysql://localhost:3306/online-food-ordering-system";
    private static final String USER = "root";
    private static final String PASSWORD = "spartans@9922";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("MySQL JDBC Driver not found: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
