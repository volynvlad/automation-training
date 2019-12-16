package com.zestcarrental.page;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
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

    private static final String CLASS_NAME_PREV_BUTTON = "ui-datepicker-prev ui-corner-all";
    private static final String CLASS_NAME_NEXT_BUTTON = "ui-datepicker-next ui-corner-all";

    private static final String CLASS_NAME_CURRENT_DAY = "ui-state-default ui-state-highlight ui-state-active";
    private static final String CLASS_NAME_DAY = "//a[@class='ui-state-default']";
    private static final String CLASS_NAME_MONTH = "ui-datepicker-month";
    private static final String CLASS_NAME_YEAR = "ui-datepicker-year";

    private static final String ABSOLUTE_PATH_PICKUP_MINUTE = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[3]/div[2]/span[1]/span[1]/span/span[1]";
    private static final String ABSOLUTE_PATH_PICKUP_HOUR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[3]/div[2]/span[3]/span[1]/span/span[1]";
    private static final String ABSOLUTE_PATH_RETURN_MINUTE = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[3]/div[2]/span[1]/span[1]/span/span[1]";
    private static final String ABSOLUTE_PATH_RETURN_HOUR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[3]/div[2]/span[3]/span[1]/span/span[1]";

    private static final String ID_DROPDOWN_PICKUP_HOUR = "select2-pickup_time_hours-pa-results";
    private static final String ID_DROPDOWN_PICKUP_MINUTE = "select2-pickup_time_minutes-th-results";
    private static final String ID_DROPDOWN_RETURN_HOUR = "select2-pickup_time_hours-pa-results";
    private static final String ID_DROPDOWN_RETURN_MINUTE = "select2-pickup_time_minutes-th-results";

    private static final String ABSOLUTE_PATH_INPUT_DRIVER_AGE = "/html/body/div[1]/div/section[1]/form/fieldset[2]/p/input[2]";
    private static final String ABSOLUTE_PATH_FIND_CAR_BUTTON = "/html/body/div[1]/div/section[1]/form/footer/button";

    private static final String CLASS_NAME_FEEDBACK_MESSAGE = "feedback--is_error";


    @FindBy(className = CLASS_NAME_CALENDAR)
    private WebElement datePickUpCalendar;

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_CALENDAR)
    private WebElement pickupCalendar;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_CALENDAR)
    private WebElement returnCalendar;

    @FindBy(className = CLASS_NAME_PREV_BUTTON)
    private WebElement prevButton;

    @FindBy(className = CLASS_NAME_NEXT_BUTTON)
    private WebElement nextButton;

    @FindBy(className = CLASS_NAME_CURRENT_DAY)
    private WebElement currentDatePickerDay;

    private List<WebElement> datesPickerDay = webDriver.findElements(By.xpath(CLASS_NAME_DAY));

    @FindBy(className = CLASS_NAME_MONTH)
    private WebElement datePickerMonth;

    @FindBy(className = CLASS_NAME_YEAR)
    private WebElement datePickerYear;

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_HOUR)
    private WebElement pickupHour;

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_MINUTE)
    private WebElement pickupMinute;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_HOUR)
    private WebElement returnHour;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_MINUTE)
    private WebElement returnMinute;

    private List<WebElement> dropdownPickupHour = webDriver.findElements(By.id(ID_DROPDOWN_PICKUP_HOUR));

    private List<WebElement> dropdownPickupMinute = webDriver.findElements(By.id(ID_DROPDOWN_PICKUP_MINUTE));

    private List<WebElement> dropdownReturnHour = webDriver.findElements(By.id(ID_DROPDOWN_RETURN_HOUR));

    private List<WebElement> dropdownReturnMinute = webDriver.findElements(By.id(ID_DROPDOWN_RETURN_MINUTE));

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
        return currentDatePickerDay.getAttribute("value");
    }

    public String getDatePickerMonth() {
        return datePickerMonth.getAttribute("value");
    }

    public String getDatePickerYear() {
        return datePickerYear.getAttribute("value");
    }

    public DateQuotePage choosePickupDate(CarDestinationCriteria criteria) {
        logger.info("Choose pickup date");

        String chosenMonth = this.getDatePickerMonth();
        int chosenYear = Integer.parseInt(this.getDatePickerYear());

        while (true) {
            if (Integer.parseInt(criteria.getYearPickup()) > chosenYear) {
                pickupCalendar.findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
            } else if (Integer.parseInt(criteria.getYearPickup()) < chosenYear) {
                pickupCalendar.findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
            } else {
                if (findIndex(MONTHS, criteria.getMonthPickup()) > findIndex(MONTHS, chosenMonth)) {
                    pickupCalendar.findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
                } else if (findIndex(MONTHS, criteria.getMonthPickup()) < findIndex(MONTHS, chosenMonth)) {
                    pickupCalendar.findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
                } else {
                    break;
                }
            }
        }

        pickupCalendar.findElements(By.xpath(CLASS_NAME_DAY)).stream()
                .filter(e -> e.getText().equals(String.valueOf(criteria.getDayPickup())))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage chooseReturnDate(CarDestinationCriteria criteria) {
        logger.info("Choose return date");

        String chosenMonth = this.getDatePickerMonth();
        int chosenYear = Integer.parseInt(this.getDatePickerYear());

        while (true) {
            if (Integer.parseInt(criteria.getYearReturn()) > chosenYear) {
                returnCalendar.findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
            } else if (Integer.parseInt(criteria.getYearReturn()) < chosenYear) {
                returnCalendar.findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
            } else {
                if (findIndex(MONTHS, criteria.getMonthReturn()) > findIndex(MONTHS, chosenMonth)) {
                    returnCalendar.findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
                } else if (findIndex(MONTHS, criteria.getMonthReturn()) < findIndex(MONTHS, chosenMonth)) {
                    returnCalendar.findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
                } else {
                    break;
                }
            }
        }

        returnCalendar.findElements(By.xpath(CLASS_NAME_DAY)).stream()
                .filter(e -> e.getText().equals(String.valueOf(criteria.getDayReturn())))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage choosePickupTime(CarDestinationCriteria criteria) {
        logger.info("Choose pickup time");

        pickupHour.click();

        dropdownPickupHour.stream().filter(e -> e.getText().equals(String.valueOf(criteria.getHourPickup()))).forEach(WebElement::click);

        pickupMinute.click();

        dropdownPickupMinute.stream().filter(e -> e.getText().equals(String.valueOf(criteria.getMinutePickup()))).forEach(WebElement::click);

        return this;
    }

    public DateQuotePage chooseReturnTime(CarDestinationCriteria criteria) {
        logger.info("Choose return time");

        returnHour.click();

        dropdownReturnHour.stream().filter(e -> e.getText().equals(String.valueOf(criteria.getHourReturn()))).forEach(WebElement::click);

        returnMinute.click();

        dropdownReturnMinute.stream().filter(e -> e.getText().equals(String.valueOf(criteria.getMinuteReturn()))).forEach(WebElement::click);

        return this;
    }

    public String getErrorMessage() {
        return feedbackMessage.getText();
    }

    public DateQuotePage inputDriverAge(User user) {
        logger.info("Input driver age");

        inputDriverAge.click();
        inputDriverAge.sendKeys(String.valueOf(user.getAge()));

        return this;
    }

    public ResultQuotePage findCar() {
        logger.info("Find car");

        findCarButton.click();

        return new ResultQuotePage(webDriver);
    }
}
