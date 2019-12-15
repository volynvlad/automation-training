package com.zestcarrental.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingPageExtras extends AbstractPage {

    private static final String CLASS_NAME_CURRENT_STEP = "current";

    private static final String ABSOLUTE_PATH_NEXT_STEP = "/html/body/div[1]/div/section[2]/form/div/div[1]/button/span";

    private static final String ATTRIBUTE_DATA_STEP = "data-step";

    private List<WebElement> steps = webDriver.findElements(By.tagName("//body/a"));

    @FindBy(className = CLASS_NAME_CURRENT_STEP)
    private WebElement currentStep;

    @FindBy(xpath = ABSOLUTE_PATH_NEXT_STEP)
    private WebElement nextStep;

    public BookingPageExtras(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public BookingPageExtras openPage() {
        logger.info("Open booking extras page");

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public BookingPageInsurance nextStep() {
        logger.info("Next step");

        nextStep.click();

        return new BookingPageInsurance(webDriver);
    }
}
