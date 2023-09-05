package com.automation.uat.pages.home;

import com.automation.uat.support.PageObject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePageObject extends PageObject {

    private final String headerProduct = "//span[contains(@class, 'title')]";
    private final String menuItemLogout = "#logout_sidebar_link";

    public HomePageObject(Page page) {
        super(page);
    }


    public Locator getHeaderElement() {
        return page.locator(headerProduct);
    }

    public Locator getLogoutElement() {
        return page.locator(menuItemLogout);
    }

    public Locator getTestElement() {
        return page.locator("#login-button");
    }



}
