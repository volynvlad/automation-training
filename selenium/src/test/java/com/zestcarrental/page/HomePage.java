package com.zestcarrental.page;

import com.zestcarrental.model.CarDestinationCriteria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.zestcarrental.util.StringUtils.HOMEPAGE_URL;

public class HomePage extends AbstractPage {

    private static final String SEARCH_PICKUP_ID = "search_pickup_location_name";

    private static final String SEARCH_BUTTON_SUBMIT_CLASSNAME = "search_form__submit";

    private static final String CLASS_NAME_FIELD_SUGGESTIONS = "field_suggestions__suggestion";

    private static final String TAG_NAME_BUTTON = "button";

    private static final String ATTRIBUTE_DATA_NAME = "data-name";

    @FindBy(id = SEARCH_PICKUP_ID)
    private WebElement searchPickup;

    @FindBy(className = SEARCH_BUTTON_SUBMIT_CLASSNAME)
    private WebElement buttonGo;

    //private Select dropdown = new Select(webDriver.findElement(By.className(CLASS_NAME_FIELD_SUGGESTIONS)));

    //private Select dropdown = new Select(webDriver.findElement(By.tagName(TAG_NAME_BUTTON)));

    private List<WebElement> elements = webDriver.findElements(By.className(CLASS_NAME_FIELD_SUGGESTIONS));

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HomePage openPage() {
        logger.info("Open home page");

        webDriver.get(HOMEPAGE_URL);

        return this;
    }

    public DateQuotePage searchForLocation(CarDestinationCriteria criteria) {
        logger.info("Search for location");

        searchPickup.click();
        searchPickup.sendKeys(criteria.getLocationPickup());
        searchPickup.click();
        //dropdown.selectByVisibleText(criteria.getLocationPickup());
        System.out.println(elements);
        System.out.println("---------elements---------------");
        for (WebElement element : elements) {
            System.out.println(element.getAttribute(ATTRIBUTE_DATA_NAME));
        }
        System.out.println("---------elements---------------");
        elements.stream().filter(e -> e.getAttribute(ATTRIBUTE_DATA_NAME).equals(criteria.getLocationPickup())).forEach(WebElement::click);
        buttonGo.click();
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return new DateQuotePage(webDriver);
    }
}
