package com.automation.uat.features.login;

import com.automation.uat.pages.home.HomePageObject;

public class LoginContext {
    public HomePageObject homePage;
    public HomePageObject getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePageObject homePage) {
        this.homePage = homePage;
    }


}
