package com.zestcarrental.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 15;

    protected WebDriver webDriver;
    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
