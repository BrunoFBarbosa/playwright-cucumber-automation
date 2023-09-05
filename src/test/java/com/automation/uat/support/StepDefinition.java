package com.automation.uat.support;

import com.microsoft.playwright.Page;

public class StepDefinition {

    protected final Page page;

    public StepDefinition(PlaywrightDependency dependency) {
        this.page = dependency.getPage();
    }

}
