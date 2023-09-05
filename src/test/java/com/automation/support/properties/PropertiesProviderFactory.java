package com.automation.support.properties;

import java.util.HashMap;
import java.util.Map;

public class PropertiesProviderFactory {

    private static final String ENVIRONMENT_NAME_VAR = "QA_ENVIRONMENT";
    private static final Map<String, PropertiesProvider> providers = new HashMap<>();

    private PropertiesProviderFactory() {
    }

    public static PropertiesProvider getJavaPropertiesProvider(String scope) {
        String environmentName = getExecutionEnvironmentName();
        String key = buildKey(scope, environmentName);
        return providers.computeIfAbsent(key, (k) -> new JavaPropertiesProvider(scope, environmentName));
    }

    private static String buildKey(String scope,
                                   String environmentName) {
        return String.format("%s%s", scope, environmentName);
    }

    private static String getExecutionEnvironmentName() {
        return System.getProperty(ENVIRONMENT_NAME_VAR, "qa");
    }


}
