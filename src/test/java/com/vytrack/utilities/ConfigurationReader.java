package com.vytrack.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

// mvn test -Dconfig=regression
    static {

        try {
            String path;
            String config = System.getProperty("config");
            if (config == null)
                config = "default";
            switch (config) {

                case "regression":
                    path  = "config/regressionConfig.properties";
                    break;
                    default:
                    path  = "config/configuration.properties";
            }

            System.out.println("path = " + path);

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}