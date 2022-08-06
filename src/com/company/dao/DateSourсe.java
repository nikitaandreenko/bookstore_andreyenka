package com.company.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DateSourсe {
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    private Connection connection;
    private Properties properties;

    public Connection getConnection() {
        if (connection == null) {
            try {
                properties = new Properties();
                properties.load(DateSourсe.class.getClassLoader().getResourceAsStream
                        ("application.properties"));
                connection = DriverManager.getConnection(
                        properties.getProperty(URL_KEY),
                        properties.getProperty(USER_KEY),
                        properties.getProperty(PASSWORD_KEY)
                );
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
