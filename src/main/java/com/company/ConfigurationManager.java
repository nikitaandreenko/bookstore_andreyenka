package com.company;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    public static final ConfigurationManager INSTANCE = new ConfigurationManager();
    private final Properties props;

    private ConfigurationManager() {
        props = new Properties();
        try {
            props.load(getClass().getResourceAsStream
                    ("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getProperty(String key) {
        return props.getProperty(key);
    }
}
