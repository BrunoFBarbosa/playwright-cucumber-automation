package com.automation.uat.pages.login;

import com.automation.uat.pages.home.HomePageObject;
import com.automation.uat.support.PageObject;
import com.automation.uat.support.UatProperties;
import com.microsoft.playwright.Page;

public class LoginPageObject extends PageObject {

    private final String inputUserName = "#user-name";

    private final String inputPassword = "#password";
    private final String btnLogin = "#login-button";
    private final String lblError = "//h3[@data-test='error']";

    public LoginPageObject(Page page) {
        super(page);
    }

    public LoginPageObject navigateTo() {
        page.navigate(UatProperties.LOGIN_PAGE_URL.value());
        return this;
    }

    public LoginPageObject setUsername(String username) {
        page.locator(inputUserName).type(username);
        return this;
    }

    public LoginPageObject setPassword(String password) {
        page.locator(inputPassword).type(password);
        return this;
    }

    public HomePageObject clickLogin() {
        page.locator(btnLogin).click();
        return new HomePageObject(page);
    }

    public String getErrorMessage() {
        return page.locator(lblError).textContent();
    }



}
