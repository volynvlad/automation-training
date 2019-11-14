package com.zestcarrental.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DateQuotePage extends Page {

    @FindBy(xpath = "//*[@id=\"dp1573717085067\"]/div/div/a[2]")
    private WebElement returnDateNextButton;

    @FindBy(xpath = "//*[@id=\"dp1573717085067\"]/div/table/tbody/tr[4]/td[5]/a")
    private WebElement numberInReturnDateCalendar; // 24

    @FindBy(xpath = "//*[@id=\"select2-pickup_time_hours-f7-container\"]")
    private WebElement pickUpTimeHourSelector;
    @FindBy(xpath = "//*[@id=\"select2-pickup_time_minutes-v4-container\"]")
    private WebElement pickUpTimeMinuteSelector;
    @FindBy(xpath = "//*[@id=\"select2-return_time_hours-vb-container\"]")
    private WebElement returnTimeHourSelector;
    @FindBy(xpath = "//*[@id=\"select2-return_time_minutes-83-container\"]")
    private WebElement returnTimeMinuteSelector;

    @FindBy(xpath = "//*[@id=\"select2-pickup_time_hours-f7-result-4ll6-16\"]")
    private WebElement chosenNumberOfHoursPickupSelector; // 16
    @FindBy(xpath = "//*[@id=\"select2-pickup_time_minutes-v4-result-ngy3-00\"]")
    private WebElement chosenNumberOfMinutesPickupSelector; // 00
    @FindBy(xpath = "//*[@id=\"select2-return_time_minutes-83-container\"]")
    private WebElement chosenNumberOfHoursReturnSelector; // 00
    @FindBy(xpath = "//*[@id=\"select2-return_time_minutes-83-result-qnm2-00\"]")
    private WebElement chosenNumberOfMinutesReturnSelector; // 00

    @FindBy(xpath = "/html/body/div[1]/div/section[1]/form/footer/button")
    private WebElement findCarButton;

    public DateQuotePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public DateQuotePage choosePickupDate() {
        pickUpTimeHourSelector.click();
        chosenNumberOfHoursPickupSelector.click();

        pickUpTimeMinuteSelector.click();
        chosenNumberOfMinutesPickupSelector.click();
        return this;
    }

    public DateQuotePage chooseReturnDate() {
        returnDateNextButton.click();
        returnDateNextButton.click();

        numberInReturnDateCalendar.click();

        returnTimeHourSelector.click();
        chosenNumberOfHoursReturnSelector.click();

        returnTimeMinuteSelector.click();
        chosenNumberOfMinutesReturnSelector.click();
        return this;
    }

    public DateQuotePage findCar() {
        findCarButton.click();
        return this;
    }

    @Override
    public DateQuotePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }
}
