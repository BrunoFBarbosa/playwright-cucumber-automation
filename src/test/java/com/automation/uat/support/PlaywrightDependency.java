package com.automation.uat.support;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;

public class PlaywrightDependency {

    private Playwright playwright;
    private Page page;
    private Browser browser;

    public PlaywrightDependency() {
        setupPlaywright();
        setupBrowser();
        setupPage();
    }

    private void setupPlaywright() {
        this.playwright = Playwright.create();
    }

    private void setupBrowser() {
        String browserName = UatProperties.BROWSER_NAME.value();
        BrowserType browserType = switch (browserName) {
            case "chrome" -> playwright.chromium();
            case "firefox" -> playwright.firefox();
            default -> throw new IllegalArgumentException("Invalid browser: " + browserName);
        };
        this.browser = browserType.launch(browserOptions());
    }

    private BrowserType.LaunchOptions browserOptions() {
        return new BrowserType.LaunchOptions()
                .setHeadless(Boolean.parseBoolean(UatProperties.HEADLESS_BROWSER.value()));
    }

    private void setupPage() {
        this.page = browser.newPage();
    }

    public Page getPage() {
        return this.page;
    }

}
