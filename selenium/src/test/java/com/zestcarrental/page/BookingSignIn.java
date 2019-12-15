package com.zestcarrental.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import java.util.concurrent.TimeUnit;

public class BookingSignIn extends AbstractPage {
    private static final String CLASS_NAME_CURRENT_STEP = "current";

    private static final String CLASS_NAME_CONTINUE = "button button--solid button--block button--green";

    private static final String CSS_SELECTOR_NEW_TYPE = "label[for='customer_type_new']";

    private static final String CSS_SELECTOR_TYPE_REPEAT = "label[for='customer_type_repeat']";

    private static final String ID_CUSTOMER_MAIL = "customer_email";

    private static final String ID_CUSTOMER_PASSWORD = "customer_password";

    @FindBy(className = CLASS_NAME_CURRENT_STEP)
    private WebElement currentStep;

    @FindBy(className = CLASS_NAME_CONTINUE)
    private WebElement continueButton;

    private WebElement newTypeCustomerLabel = webDriver.findElement(By.cssSelector(CSS_SELECTOR_NEW_TYPE));

    private WebElement repeatTypeCustomerLabel = webDriver.findElement(By.cssSelector(CSS_SELECTOR_TYPE_REPEAT));

    @FindBy(id = ID_CUSTOMER_MAIL)
    private WebElement customerMailInput;

    @FindBy(id = ID_CUSTOMER_PASSWORD)
    private WebElement customerPasswordInput;

    public BookingSignIn(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public BookingSignIn openPage() {
        logger.info("Open booking sing in page");

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public BookingSignIn fillForm(boolean isNew, String customerMail, String customerPassword) {
        logger.info("Fill sing in form");

        if (isNew) {
            newTypeCustomerLabel.click();

            customerMailInput.click();
            customerMailInput.sendKeys(customerMail);
        } else {
            repeatTypeCustomerLabel.click();

            customerMailInput.click();
            customerMailInput.sendKeys(customerMail);

            customerPasswordInput.click();
            customerPasswordInput.sendKeys(customerPassword);
        }

        return this;
    }

    public BookingCustomerDetails pressContinue() {
        logger.info("Press continue");

        continueButton.click();

        return new BookingCustomerDetails(webDriver);
    }
}

