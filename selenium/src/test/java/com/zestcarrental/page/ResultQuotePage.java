package com.zestcarrental.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultQuotePage extends AbstractPage {

    private static final String CLASS_NAME_VEHICLE_BOOKING = "vehicle_booking__action vehicle_booking__action--book";

    List<WebElement> elements = webDriver.findElements(By.className(CLASS_NAME_VEHICLE_BOOKING));

    public ResultQuotePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }


    @Override
    public ResultQuotePage openPage() {
        logger.info("Open result quote page");

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public BookingPage bookCar(int num) {
        logger.info("Book car");

        elements.get(num - 1).click();

        return new BookingPage(webDriver);
    }
}
