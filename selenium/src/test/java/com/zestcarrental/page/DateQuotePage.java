package com.zestcarrental.page;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.zestcarrental.util.StringUtils.MONTHS;
import static com.zestcarrental.util.StringUtils.HOMEPAGE_URL;
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
    List<WebElement> datesPickerDay = webDriver.findElements(By.xpath(CLASS_NAME_DAY));
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

    List<WebElement> dropdownPickupHour = webDriver.findElements(By.id(ID_DROPDOWN_PICKUP_HOUR));
    List<WebElement> dropdownPickupMinute = webDriver.findElements(By.id(ID_DROPDOWN_PICKUP_MINUTE));
    List<WebElement> dropdownReturnHour = webDriver.findElements(By.id(ID_DROPDOWN_RETURN_HOUR));
    List<WebElement> dropdownReturnMinute = webDriver.findElements(By.id(ID_DROPDOWN_RETURN_MINUTE));

    @FindBy(xpath = ABSOLUTE_PATH_INPUT_DRIVER_AGE)
    private WebElement inputDriverAge;
    @FindBy(xpath = ABSOLUTE_PATH_FIND_CAR_BUTTON)
    private WebElement findCarButton;


    public DateQuotePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public DateQuotePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        logger.info("Open date quote page");

        return this;
    }

    public WebElement getPickupCalendar() {
        logger.info("Get pickUp Calendar");
        return pickupCalendar;
    }

    public WebElement getReturnCalendar() {
        logger.info("Get return Calendar");
        return returnCalendar;
    }

    public String getDatePickerDay() {
        logger.info("Get day from date picker");
        return currentDatePickerDay.getAttribute("value");
    }

    public String getDatePickerMonth() {
        logger.info("Get month from date picker");
        return datePickerMonth.getAttribute("value");
    }

    public String getDatePickerYear() {
        logger.info("Get year from date picker");
        return datePickerYear.getAttribute("value");
    }

    public DateQuotePage choosePickupDate(int day, String month, int year) {
        logger.info("Choose pickup date");

        int chosenDay = Integer.parseInt(this.getDatePickerDay());
        String chosenMonth = this.getDatePickerMonth();
        int chosenYear = Integer.parseInt(this.getDatePickerYear());

        while (true) {
            if (year > chosenYear) {
                this.getPickupCalendar().findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
            } else if (year < chosenYear) {
                this.getPickupCalendar().findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
            } else {
                if (findIndex(MONTHS, month) > findIndex(MONTHS, chosenMonth)) {
                    this.getPickupCalendar().findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
                } else if (findIndex(MONTHS, month) < findIndex(MONTHS, chosenMonth)) {
                    this.getPickupCalendar().findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
                } else {
                    break;
                }
            }
        }

        getPickupCalendar().findElements(By.xpath(CLASS_NAME_DAY)).stream()
                .filter(e -> e.getText().equals(String.valueOf(day)))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage chooseReturnDate(int day, String month, int year) {
        logger.info("Choose return date");

        int chosenDay = Integer.parseInt(this.getDatePickerDay());
        String chosenMonth = this.getDatePickerMonth();
        int chosenYear = Integer.parseInt(this.getDatePickerYear());

        while (true) {
            if (year > chosenYear) {
                this.getReturnCalendar().findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
            } else if (year < chosenYear) {
                this.getReturnCalendar().findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
            } else {
                if (findIndex(MONTHS, month) > findIndex(MONTHS, chosenMonth)) {
                    this.getReturnCalendar().findElement(By.className(CLASS_NAME_PREV_BUTTON)).click();
                } else if (findIndex(MONTHS, month) < findIndex(MONTHS, chosenMonth)) {
                    this.getReturnCalendar().findElement(By.className(CLASS_NAME_NEXT_BUTTON)).click();
                } else {
                    break;
                }
            }
        }

        getReturnCalendar().findElements(By.xpath(CLASS_NAME_DAY)).stream()
                .filter(e -> e.getText().equals(String.valueOf(day)))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage choosePickupTime(int hour, int minute) {
        logger.info("Choose pickup time");

        pickupHour.click();

        dropdownPickupHour.stream().filter(e -> e.getText().equals(String.valueOf(hour))).forEach(WebElement::click);

        pickupMinute.click();

        dropdownPickupMinute.stream().filter(e -> e.getText().equals(String.valueOf(minute))).forEach(WebElement::click);

        return this;
    }

    public DateQuotePage chooseReturnTime(int hour, int minute) {
        logger.info("Choose return time");

        returnHour.click();

        dropdownReturnHour.stream().filter(e -> e.getText().equals(String.valueOf(hour))).forEach(WebElement::click);

        returnMinute.click();

        dropdownReturnMinute.stream().filter(e -> e.getText().equals(String.valueOf(minute))).forEach(WebElement::click);

        return this;
    }

    public DateQuotePage inputDriverAge(int age) {
        logger.info("Input driver age");

        inputDriverAge.click();
        inputDriverAge.sendKeys(String.valueOf(age));

        return this;
    }

    public ResultQuotePage findCar() {
        logger.info("Find car");

        findCarButton.click();

        return new ResultQuotePage(webDriver);
    }
}
