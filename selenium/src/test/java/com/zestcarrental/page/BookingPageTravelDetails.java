package com.zestcarrental.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BookingPageTravelDetails extends AbstractPage {
    private static final String CLASS_NAME_CURRENT_STEP = "current";

    private static final String ID_FIRST_NAME = "first_name";

    private static final String ID_LAST_NAME = "last_name";

    private static final String CLASS_NAME_AGE = "ws-number ws-inputreplace wsshadow-1576415760766 has-input-buttons";

    private static final String ID_MOBILE_NUMBER = "mobile_number";

    private static final String ABSOLUTE_PATH_NEXT_STEP = "/html/body/div[1]/div/section[2]/form/div/div[1]/button/span";

    private static final String CSS_SELECTOR_DRIVER_BALANCE = "label[for='driver_balance']";

    private static final String CSS_SELECTOR_DRIVER_TERMS = "label[for='driver_terms']";

    @FindBy(className = CLASS_NAME_CURRENT_STEP)
    private WebElement currentStep;

    @FindBy(id = ID_FIRST_NAME)
    private WebElement firstNameInput;

    @FindBy(id = ID_LAST_NAME)
    private WebElement lastNameInput;

    @FindBy(className = CLASS_NAME_AGE)
    private WebElement ageInput;

    @FindBy(id = ID_MOBILE_NUMBER)
    private WebElement mobileNumberInput;

    @FindBy(xpath = ABSOLUTE_PATH_NEXT_STEP)
    private WebElement nextStep;

    private WebElement driverBalanceLabel = webDriver.findElement(By.cssSelector(CSS_SELECTOR_DRIVER_BALANCE));

    private WebElement driverTermsLabel = webDriver.findElement(By.cssSelector(CSS_SELECTOR_DRIVER_TERMS));

    public BookingPageTravelDetails(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public BookingPageTravelDetails openPage() {
        logger.info("Open booking travel details page");

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public BookingPageTravelDetails fillForm(String firstName, String lastName, String age, String mobileNumber) {
        logger.info("Fill main driver details form");

        firstNameInput.click();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.sendKeys(lastName);

        ageInput.click();
        ageInput.sendKeys(age);

        mobileNumberInput.click();
        mobileNumberInput.sendKeys(mobileNumber);

        return this;
    }

    public BookingPageTravelDetails acceptDepositRequirements() {
        logger.info("Accept deposit requirements");

        driverBalanceLabel.click();

        driverTermsLabel.click();

        return this;
    }

    public BookingSignIn nextStep() {
        logger.info("Next step");

        nextStep.click();

        return new BookingSignIn(webDriver);
    }
}
