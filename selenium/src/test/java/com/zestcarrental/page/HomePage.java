package com.zestcarrental.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends Page {

    @FindBy(xpath = "//*[@id=\"search_pickup_location_name\"]")
    private WebElement searchPickup;
    @FindBy(xpath = "//*[@id=\"book-now\"]/div/div[2]/form/button")
    private WebElement buttonGo;

    @FindBy(xpath = "//*[@id=\"book-now\"]/div/div[2]/form/div[1]/div/button[1]")
    private WebElement berlinDropDownButton;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public HomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }

    public DateQuotePage searchForLocation(String location) {
        searchPickup.click();
        searchPickup.sendKeys(location);
        searchPickup.click();
        berlinDropDownButton.click();
        buttonGo.click();
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return new DateQuotePage(webDriver);
    }
}
