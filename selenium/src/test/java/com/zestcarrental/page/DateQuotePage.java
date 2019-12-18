package com.zestcarrental.page;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
import com.zestcarrental.service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.zestcarrental.util.StringUtils.MONTHS;
import static com.zestcarrental.util.ArrayUtils.findIndex;

public class DateQuotePage extends AbstractPage {

    private static final String CLASS_NAME_CALENDAR = "ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all";

    private static final String ABSOLUTE_PATH_PICKUP_CALENDAR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/h3[1]";

    private static final String ABSOLUTE_PATH_RETURN_CALENDAR= "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/h3[1]";

    private static final String CLASS_NAME_CURRENT_DAY = "ui-state-default ui-state-highlight ui-state-active";

    private static final String CLASS_NAME_DAY = "ui-state-default";

    private static final String ABSOLUTE_PATH_PICKUP_MINUTE = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[3]/div[2]/span[3]/span[1]/span/span[1]";

    private static final String ABSOLUTE_PATH_PICKUP_HOUR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[3]/div[2]/span[1]/span[1]/span/span[1]";

    private static final String ABSOLUTE_PATH_RETURN_MINUTE = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[3]/div[2]/span[3]/span[1]/span/span[1]";

    private static final String ABSOLUTE_PATH_RETURN_HOUR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[3]/div[2]/span[1]/span[1]/span/span[1]";

    private static final String CLASS_NAME_PICKUP_HOUR = "select2-results__option";

    private static final String CLASS_NAME_PICKUP_MINUTE = "select2-results__option";

    private static final String CLASS_NAME_RETURN_HOUR = "select2-results__option";

    private static final String CLASS_NAME_RETURN_MINUTE = "select2-results__option";

    private static final String ABSOLUTE_PATH_INPUT_DRIVER_AGE = "/html/body/div[1]/div/section[1]/form/fieldset[2]/p/input[2]";

    private static final String ABSOLUTE_PATH_FIND_CAR_BUTTON = "/html/body/div[1]/div/section[1]/form/footer/button";

    private static final String CLASS_NAME_FEEDBACK_MESSAGE = "feedback--is_error";

    private static final String CSS_SELECTOR_PREV = "a[title='Prev']";

    private static final String CSS_SELECTOR_NEXT = "a[title='Next']";

    private static final String CSS_SELECTOR_MONTH = ".ui-datepicker-month";

    private static final String CSS_SELECTOR_YEAR = ".ui-datepicker-year";

    private static final String HTML_TAG_TD = "td";

    @FindBy(className = CLASS_NAME_CALENDAR)
    private WebElement datePickUpCalendar;

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_CALENDAR)
    private WebElement pickupCalendar;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_CALENDAR)
    private WebElement returnCalendar;

    @FindBy(className = CLASS_NAME_CURRENT_DAY)
    private WebElement currentDatePickerDay;

    private List<WebElement> datesPickerDay = webDriver.findElements(By.xpath(CLASS_NAME_DAY));

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_HOUR)
    private WebElement pickupHour;

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_MINUTE)
    private WebElement pickupMinute;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_HOUR)
    private WebElement returnHour;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_MINUTE)
    private WebElement returnMinute;

    @FindBy(xpath = ABSOLUTE_PATH_INPUT_DRIVER_AGE)
    private WebElement inputDriverAge;

    @FindBy(xpath = ABSOLUTE_PATH_FIND_CAR_BUTTON)
    private WebElement findCarButton;

    @FindBy(className = CLASS_NAME_FEEDBACK_MESSAGE)
    private WebElement feedbackMessage;

    public DateQuotePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public DateQuotePage openPage() {
        logger.info("Open date quote page");

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public String getDatePickerDay() {
        return currentDatePickerDay.getText();
    }

    public DateQuotePage choosePickupDate(CarDestinationCriteria criteria) {
        logger.info("Choose pickup date");

        String chosenMonth = pickupCalendar.findElement(By.cssSelector(CSS_SELECTOR_MONTH)).getText();

        String chosenYear = pickupCalendar.findElement(By.cssSelector(CSS_SELECTOR_YEAR)).getText();

        while (true) {
            if (Integer.parseInt(criteria.getYearPickup()) < Integer.parseInt(chosenYear)) {
                chosenYear = Helper.clickAndUpdate(pickupCalendar, By.cssSelector(CSS_SELECTOR_PREV), By.cssSelector(CSS_SELECTOR_YEAR));
            } else if (Integer.parseInt(criteria.getYearPickup()) > Integer.parseInt(chosenYear)) {
                chosenYear = Helper.clickAndUpdate(pickupCalendar, By.cssSelector(CSS_SELECTOR_NEXT), By.cssSelector(CSS_SELECTOR_YEAR));
            } else {
                if (findIndex(MONTHS, MONTHS[Integer.parseInt(criteria.getMonthPickup())]) < findIndex(MONTHS, chosenMonth)) {
                    chosenMonth = Helper.clickAndUpdate(pickupCalendar, By.cssSelector(CSS_SELECTOR_PREV), By.cssSelector(CSS_SELECTOR_MONTH));
                } else if (findIndex(MONTHS, MONTHS[Integer.parseInt(criteria.getMonthPickup())]) > findIndex(MONTHS, chosenMonth)) {
                    chosenMonth = Helper.clickAndUpdate(pickupCalendar, By.cssSelector(CSS_SELECTOR_NEXT), By.cssSelector(CSS_SELECTOR_MONTH));
                } else {
                    break;
                }
            }
        }

        final String CSS_SELECTOR = HTML_TAG_TD + "[data-month='" + findIndex(MONTHS, pickupCalendar.findElement(By.cssSelector(CSS_SELECTOR_MONTH)).getText()) + "']";

        pickupCalendar.findElements(By.cssSelector(CSS_SELECTOR)).stream()
                .filter(e -> e.getText().equals(String.valueOf(criteria.getDayPickup())))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage chooseReturnDate(CarDestinationCriteria criteria) {
        logger.info("Choose return date");

        String chosenMonth = returnCalendar.findElement(By.cssSelector(CSS_SELECTOR_MONTH)).getText();

        String chosenYear = returnCalendar.findElement(By.cssSelector(CSS_SELECTOR_YEAR)).getText();

        while (true) {
            if (Integer.parseInt(criteria.getYearReturn()) < Integer.parseInt(chosenYear)) {
                chosenYear = Helper.clickAndUpdate(returnCalendar, By.cssSelector(CSS_SELECTOR_PREV), By.cssSelector(CSS_SELECTOR_YEAR));
            } else if (Integer.parseInt(criteria.getYearReturn()) > Integer.parseInt(chosenYear)) {
                chosenYear = Helper.clickAndUpdate(returnCalendar, By.cssSelector(CSS_SELECTOR_NEXT), By.cssSelector(CSS_SELECTOR_YEAR));
            } else {
                if (findIndex(MONTHS, MONTHS[Integer.parseInt(criteria.getMonthReturn())]) < findIndex(MONTHS, chosenMonth)) {
                    chosenMonth = Helper.clickAndUpdate(returnCalendar, By.cssSelector(CSS_SELECTOR_PREV), By.cssSelector(CSS_SELECTOR_MONTH));
                } else if (findIndex(MONTHS, MONTHS[Integer.parseInt(criteria.getMonthReturn())]) > findIndex(MONTHS, chosenMonth)) {
                    chosenMonth = Helper.clickAndUpdate(returnCalendar, By.cssSelector(CSS_SELECTOR_PREV), By.cssSelector(CSS_SELECTOR_MONTH));
                } else {
                    break;
                }
            }
        }

        final String CSS_SELECTOR = HTML_TAG_TD + "[data-month='" + findIndex(MONTHS, returnCalendar.findElement(By.cssSelector(CSS_SELECTOR_MONTH)).getText()) + "']";

        returnCalendar.findElements(By.cssSelector(CSS_SELECTOR)).stream()
                .filter(e -> e.getText().equals(criteria.getDayReturn()))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage choosePickupTime(CarDestinationCriteria criteria) {
        logger.info("Choose pickup time");

        pickupHour.click();

        Helper.waitUntil(webDriver, WAIT_TIMEOUT_SECONDS, By.className(CLASS_NAME_PICKUP_HOUR));

        List<WebElement> dropdownPickupHour = webDriver.findElements(By.className(CLASS_NAME_PICKUP_HOUR));

        dropdownPickupHour.stream().filter(e -> e.getText().equals(criteria.getHourPickup())).forEach(WebElement::click);

        pickupMinute.click();

        Helper.waitUntil(webDriver, WAIT_TIMEOUT_SECONDS, By.className(CLASS_NAME_PICKUP_MINUTE));

        List<WebElement> dropdownPickupMinute = webDriver.findElements(By.className(CLASS_NAME_PICKUP_MINUTE));

        dropdownPickupMinute.stream().filter(e -> e.getText().equals(criteria.getMinutePickup())).forEach(WebElement::click);

        return this;
    }

    public DateQuotePage chooseReturnTime(CarDestinationCriteria criteria) {
        logger.info("Choose return time");

        returnHour.click();

        Helper.waitUntil(webDriver, WAIT_TIMEOUT_SECONDS, By.className(CLASS_NAME_RETURN_HOUR));

        List<WebElement> dropdownReturnHour = webDriver.findElements(By.className(CLASS_NAME_RETURN_HOUR));

        dropdownReturnHour.stream().filter(e -> e.getText().equals(criteria.getHourReturn())).forEach(WebElement::click);

        returnMinute.click();

        Helper.waitUntil(webDriver, WAIT_TIMEOUT_SECONDS, By.className(CLASS_NAME_RETURN_MINUTE));

        List<WebElement> dropdownReturnMinute = webDriver.findElements(By.className(CLASS_NAME_RETURN_MINUTE));

        dropdownReturnMinute.stream().filter(e -> e.getText().equals(criteria.getMinuteReturn())).forEach(WebElement::click);

        return this;
    }

    public String getErrorMessage() {
        Helper.waitUntil(webDriver, WAIT_TIMEOUT_SECONDS, By.className(CLASS_NAME_FEEDBACK_MESSAGE));

        logger.info("Error message - " + feedbackMessage.getText());

        return feedbackMessage.getText();
    }

    public DateQuotePage inputDriverAge(User user) {
        Helper.clickAndSend(inputDriverAge, String.valueOf(user.getAge()));

        logger.info("Input driver age " + user.getAge());

        return this;
    }

    public DateQuotePage findCarWithError() {
        logger.info("Find car with error");

        findCarButton.click();

        return this;
    }

    public ResultQuotePage findCar() {
        logger.info("Find car");

        findCarButton.click();

        return new ResultQuotePage(webDriver);
    }
}
