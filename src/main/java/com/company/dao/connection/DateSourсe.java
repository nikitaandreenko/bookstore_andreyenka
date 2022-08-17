package com.company.dao.connection;


import com.company.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DateSourсe {

    public static final DateSourсe INSTANCE = new DateSourсe();

    private DateSourсe() {
    }


    private static final Logger log = LogManager.getLogger(DateSourсe.class);
    private static final String URL_KEY = "db.local.url";
    private static final String USER_KEY = "db.local.user";
    private static final String PASSWORD_KEY = "db.local.password";


    private Connection connection;
    public Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        log.info("Connection with database");
            try {
                connection = DriverManager.getConnection(
                        ConfigurationManager.INSTANCE.getProperty(URL_KEY),
                        ConfigurationManager.INSTANCE.getProperty(USER_KEY),
                        ConfigurationManager.INSTANCE.getProperty(PASSWORD_KEY)
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
