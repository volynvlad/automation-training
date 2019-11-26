package com.zestcarrental.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.zestcarrental.util.StringUtils.HOMEPAGE_URL;

public class BookingPage extends AbstractPage {

    public BookingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected BookingPage openPage() {
        webDriver.get(HOMEPAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }


}
