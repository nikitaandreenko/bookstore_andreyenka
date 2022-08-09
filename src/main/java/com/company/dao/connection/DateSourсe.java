package com.company.dao.connection;


import com.company.dao.BookDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DateSourсe {


    private static final Logger log = LogManager.getLogger(DateSourсe.class);
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    private Connection connection;
    private Properties properties;

    public Connection getConnection() {
        log.info("Connection with database");
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
