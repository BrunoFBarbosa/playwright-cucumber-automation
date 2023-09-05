package com.automation.support.properties;

public interface PropertiesProvider {

    String getProperty(String propertyName);

    String getProperty(String propertyName,
                       String defaultValue);

}
