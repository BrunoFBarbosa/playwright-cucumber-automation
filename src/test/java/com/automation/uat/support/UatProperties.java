package com.automation.uat.support;

import com.automation.support.properties.PropertiesProvider;
import com.automation.support.properties.PropertiesProviderFactory;

public enum UatProperties {

    BROWSER_NAME("BrowserName"),
    HEADLESS_BROWSER("HeadlessBrowser"),
    LOGIN_PAGE_URL("LoginPageUrl"),
    VALID_USER("ValidUser"),

    LOCKED_USER("LockedUser"),

    VALID_PASSWORD("ValidPassword"),

    TEST_PROP("TestProp");

    private static final PropertiesProvider properties = PropertiesProviderFactory.getJavaPropertiesProvider("uat");

    private final String value;

    UatProperties(String value) {
        this.value = value;
    }

    public String value() {
        return properties.getProperty(this.value);
    }

}
