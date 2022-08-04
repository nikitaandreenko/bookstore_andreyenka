package com.company.dao;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    private PropertiesUtil(){
    }
    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties ()  {
        try (var inpuStream = PropertiesUtil.class.getClassLoader().getResourceAsStream
                ("application.properties")){
            PROPERTIES.load(inpuStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
