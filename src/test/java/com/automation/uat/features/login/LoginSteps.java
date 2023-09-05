package com.automation.uat.features.login;
import com.automation.uat.pages.login.LoginPageObject;
import com.automation.uat.pages.home.HomePageObject;
import com.automation.uat.support.*;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends StepDefinition {
    private LoginContext loginContext;


    public LoginSteps(PlaywrightDependency playwright, LoginContext loginContext) {
        super(playwright);
        this.loginContext = loginContext;
    }

    @Given("the user is on login page")
    public void user_is_on_login_page() {
        new LoginPageObject(page)
                .navigateTo();
    }

    @When("the user logs in with a valid credential")
    public void login_with_valid_credentials() {
        LoginPageObject loginPage = new LoginPageObject(page);
        loginPage.setUsername(UatProperties.VALID_USER.value());
        loginPage.setPassword(UatProperties.VALID_PASSWORD.value());
        HomePageObject homePage = loginPage.clickLogin();
        this.loginContext.setHomePage(homePage);
    }

    @When("the user logs in with {string} credentials")
    public void login_with_credentials(String credential) {
        LoginPageObject loginPage = new LoginPageObject(page);
        String userName;
        String password;
        switch (credential.toLowerCase()) {
            case "invalid" -> {
                Faker faker = new Faker();
                userName = faker.internet().emailAddress();
                password = faker.internet().password();
            }
            case "locked" -> {
                userName = UatProperties.LOCKED_USER.value();
                password = UatProperties.VALID_PASSWORD.value();
            }
            default -> throw new IllegalArgumentException("Invalid option: " + credential);
        }
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    @Then("the home page should be visible")
    public void home_page_should_be_visible() {
        HomePageObject homePage = this.loginContext.getHomePage();
        assertThat(homePage.getHeaderElement()).isVisible();
        assertThat(homePage.getLogoutElement()).isAttached();
    }

    @Then("the login error message {string} should be visible")
    public void login_error_message_should_be_visible(String message) {
        LoginPageObject loginPage = new LoginPageObject(page);
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains(message));
    }

    @After
    public void browserTeardown() {
        this.page.context().browser().close();
    }

}
