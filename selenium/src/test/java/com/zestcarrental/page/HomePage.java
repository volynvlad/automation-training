package com.zestcarrental.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.zestcarrental.util.StringUtils.HOMEPAGE_URL;

public class HomePage extends AbstractPage {

    private static final String SEARCH_PICKUP_ID = "search_pickup_location_name";
    private static final String SEARCH_BUTTON_SUBMIT_CLASSNAME = "search_form__submit";
    private static final String BERLIN_DROP_DOWN_CLASS_NAME = "field_suggestions__suggestion field_suggestions__suggestion--station";

    @FindBy(id = SEARCH_PICKUP_ID)
    private WebElement searchPickup;
    @FindBy(className = SEARCH_BUTTON_SUBMIT_CLASSNAME)
    private WebElement buttonGo;

    @FindBy(className = BERLIN_DROP_DOWN_CLASS_NAME, ="Berlin")
    private WebElement berlinDropDownButton;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HomePage openPage() {
        webDriver.navigate().to(HOMEPAGE_URL);
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
