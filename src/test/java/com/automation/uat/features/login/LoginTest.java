package com.automation.uat.features.login;

import com.automation.uat.support.CucumberTest;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectDirectories;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.automation.uat.features.login,com.automation.uat.shared")
@SelectDirectories("./features/login.feature")
@ExcludeTags("manual")
public class LoginTest extends CucumberTest {

}
