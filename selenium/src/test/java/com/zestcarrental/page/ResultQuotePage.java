package com.zestcarrental.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.zestcarrental.util.StringUtils.CURRENCY_EUR;
import static com.zestcarrental.util.StringUtils.CURRENCY_GBP;

public class ResultQuotePage extends AbstractPage {

    private static final String ID_CURRENCY_BUTTON = "select2-currency-km-container";

    private static final String CLASS_NAME_VEHICLE_BOOKING = "vehicle_booking__action vehicle_booking__action--book";

    private static final String ID_CURRENCY_BUTTON_GBP = "select2-currency-km-result-b1kh-GBP";

    private static final String ID_CURRENCY_BUTTON_EUR = "select2-currency-km-result-vze7-EUR";

    List<WebElement> elements = webDriver.findElements(By.className(CLASS_NAME_VEHICLE_BOOKING));

    @FindBy(id = ID_CURRENCY_BUTTON)
    private WebElement currencyButton;

    private WebElement currencyEurButton;

    private WebElement currencyGbpButton;

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

    public ResultQuotePage pressCurrencyButton() {
        logger.info("Press currency button");

        currencyButton.click();

        return this;
    }

    public ResultQuotePage chooseCurrency(String currency) {
        logger.info("Choose currency");

        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);

        if (currency.equals(CURRENCY_EUR)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_CURRENCY_BUTTON_EUR)));
            currencyEurButton = webDriver.findElement(By.id(ID_CURRENCY_BUTTON_EUR));
            currencyEurButton.click();
        } else if (currency.equals(CURRENCY_GBP)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_CURRENCY_BUTTON_GBP)));
            currencyGbpButton = webDriver.findElement(By.id(ID_CURRENCY_BUTTON_GBP));
            currencyGbpButton.click();
        }

        return this;
    }

    public String currentCurrency() {
        return currencyButton.getText();
    }

    public BookingPageExtras bookCar(int num) {
        logger.info("Book car");

        elements.get(num - 1).click();

        return new BookingPageExtras(webDriver);
    }
}
