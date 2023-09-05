package com.automation.support.properties;

import java.io.InputStream;
import java.util.Properties;

public class JavaPropertiesProvider implements PropertiesProvider {

    private final Properties properties;

    public JavaPropertiesProvider(String scope,
                                  String environment) {
        this.properties = loadPropertiesFile(scope, environment);
    }

    private String getFilename(String scope,
                               String envName) {
        return String.format("/%s/%s.properties", envName, scope);
    }

    private Properties loadPropertiesFile(String scope,
                                          String envName) {
        String file = getFilename(scope, envName);
        try (InputStream input = JavaPropertiesProvider.class.getResourceAsStream(file)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Could not load properties file at %s. Please verify that the file exists.", file));
        }
    }

    @Override
    public String getProperty(String propertyName) {
        String property = properties.getProperty(propertyName);
        if (property == null) {
            throw new IllegalArgumentException(String.format("Property %s does not exist in properties file.", propertyName));
        }
        return property;
    }

    @Override
    public String getProperty(String propertyName, String defaultValue) {
        try {
            return getProperty(propertyName);
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
