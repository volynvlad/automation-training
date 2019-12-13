package com.zestcarrental.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver webDriver;

    protected final int WAIT_TIMEOUT_SECONDS = 15;

    protected final Logger logger = LogManager.getRootLogger();
    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
