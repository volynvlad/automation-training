package com.zestcarrental.page;

import com.zestcarrental.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BookingPagePayment extends AbstractPage {

    private static final String ID_CARD_NUMBER = "card_number";

    private static final String ID_EXP_MONTH = "exp_month";

    private static final String ID_EXP_YEAR = "exp_year";

    private static final String ID_NAME_ON_CARD = "capf1";

    private static final String ID_SECURITY_CODE = "cv2_number";

    private static final String ID_ERROR_MESSAGE = "pan";

    private static final String CSS_SELECTOR_CONTINUE = "button[class=\"button button--solid button--block button--green\"]";


    @FindBy(id = ID_CARD_NUMBER)
    private WebElement cardNumberInput;

    @FindBy(id = ID_EXP_MONTH)
    private WebElement expMonthInput;

    @FindBy(id = ID_EXP_YEAR)
    private WebElement expYearInput;

    @FindBy(id = ID_NAME_ON_CARD)
    private WebElement nameOnCardInput;

    @FindBy(id = ID_SECURITY_CODE)
    private WebElement securityCodeInput;

    @FindBy(id = ID_ERROR_MESSAGE)
    private WebElement errorMessage;

    private WebElement continueButton = webDriver.findElement(By.cssSelector(CSS_SELECTOR_CONTINUE));

    public BookingPagePayment(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public BookingPagePayment openPage() {
        logger.info("Open booking payment page");

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public BookingPagePayment fillForm(User user) {
        logger.info("Fill payment details form");

        cardNumberInput.click();
        cardNumberInput.sendKeys(user.getCardNumber());

        expMonthInput.click();
        expMonthInput.sendKeys(user.getExpireMonthDate());

        expYearInput.click();
        expYearInput.sendKeys(user.getExpireYearDate());

        nameOnCardInput.click();
        nameOnCardInput.sendKeys(user.getNameOnCard());

        securityCodeInput.click();
        securityCodeInput.sendKeys(String.valueOf(user.getSecurityCode()));

        return this;
    }

    public String getErrorMessage() {

    }

    public BookingPagePayment pressContinue() {
        logger.info("Press continue");

        continueButton.click();

        return new BookingPagePayment(webDriver);
    }
}
