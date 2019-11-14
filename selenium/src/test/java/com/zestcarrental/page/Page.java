package com.zestcarrental.page;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected final int WAIT_TIMEOUT_SECONDS = 15;

    protected WebDriver webDriver;
    protected abstract Page openPage();

    protected Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
