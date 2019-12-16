package com.zestcarrental.page;

import com.zestcarrental.model.CarDestinationCriteria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.zestcarrental.util.StringUtils.HOMEPAGE_URL;

public class HomePage extends AbstractPage {

    private static final String SEARCH_PICKUP_ID = "search_pickup_location_name";

    private static final String SEARCH_RETURN_ID = "search_return_location_name";

    private static final String SEARCH_BUTTON_SUBMIT_CLASSNAME = "search_form__submit";

    private static final String CLASS_NAME_FIELD_SUGGESTIONS = "field_suggestions__suggestion";

    private static final String ATTRIBUTE_DATA_NAME_FAIL_SEARCH = "No locations found.";

    private static final String ATTRIBUTE_DATA_NAME = "data-name";

    private static final String CSS_SELECTOR_RETURN_LABEL = "label[for=\"search_different_return_location\"]";

    private static final String ABSOLUTE_PATH_RETURN_LABEL = "/html/body/div[1]/div/section[1]/div/div[2]/form/label";

    @FindBy(id = SEARCH_PICKUP_ID)
    private WebElement searchPickup;

    @FindBy(className = SEARCH_BUTTON_SUBMIT_CLASSNAME)
    private WebElement buttonGo;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_LABEL)
    private WebElement returnLabel;

    private List<WebElement> pickupElements;

    private List<WebElement> returnElements;

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

    public HomePage pressReturnLabel() {
        logger.info("Press return label");


        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SELECTOR_RETURN_LABEL)));

        returnLabel = webDriver.findElement(By.cssSelector(CSS_SELECTOR_RETURN_LABEL));

        returnLabel.click();

        return this;
    }

    public HomePage writePickupLocation(CarDestinationCriteria criteria) {
        logger.info("Write pickup location");

        searchPickup.click();
        searchPickup.sendKeys(criteria.getLocationPickup());
        searchPickup.click();

        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLASS_NAME_FIELD_SUGGESTIONS)));

        pickupElements = webDriver.findElements(By.className(CLASS_NAME_FIELD_SUGGESTIONS));

        return this;
    }

    public boolean isNoLocation() {
        logger.info("Is no location");

        for (WebElement element : pickupElements) {
            if(element.getAttribute(ATTRIBUTE_DATA_NAME).equals(ATTRIBUTE_DATA_NAME_FAIL_SEARCH)) {
                return true;
            }
        }

        return false;
    }

    public HomePage choosePickupLocationFromDropdown(CarDestinationCriteria criteria) {
        logger.info("Search for location");

        pickupElements.stream().filter(e -> e.getAttribute(ATTRIBUTE_DATA_NAME).equals(criteria.getLocationPickup())).forEach(WebElement::click);

        return this;
    }

    public HomePage chooseReturnLocationFromDropdown(CarDestinationCriteria criteria) {
        logger.info("Choose return location");

        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLASS_NAME_FIELD_SUGGESTIONS)));

        returnElements = webDriver.findElements(By.className(CLASS_NAME_FIELD_SUGGESTIONS));

        returnElements.stream().filter(e -> e.getAttribute(ATTRIBUTE_DATA_NAME).equals(criteria.getLocationPickup())).forEach(WebElement::click);

        return this;
    }

    public DateQuotePage pressGoButton() {
        logger.info("Press go button");

        buttonGo.click();

        return new DateQuotePage(webDriver);
    }
}
