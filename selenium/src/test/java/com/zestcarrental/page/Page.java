package com.zestcarrental.page;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected final int WAIT_TIMEOUT_SECONDS = 15;
    protected static final String HOMEPAGE_URL = "https://www.zestcarrental.com/";

    protected WebDriver webDriver;
    protected abstract Page openPage();

    protected Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
