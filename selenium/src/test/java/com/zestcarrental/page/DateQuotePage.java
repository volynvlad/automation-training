package com.zestcarrental.page;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    private static final String ABSOLUTE_PATH_PICKUP_MONTH = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[2]/div[2]/div/div/div/span[1]";

    private static final String ABSOLUTE_PATH_PICKUP_YEAR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[2]/div[2]/div/div/div/span[2]";

    private static final String ABSOLUTE_PATH_RETURN_MONTH = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[2]/div[2]/div/div/div/span[1]";

    private static final String ABSOLUTE_PATH_RETURN_YEAR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[2]/div[2]/div/div/div/span[2]";

    private static final String ABSOLUTE_PATH_PICKUP_MINUTE = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[3]/div[2]/span[3]/span[1]/span/span[1]";

    private static final String ABSOLUTE_PATH_PICKUP_HOUR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[3]/div[2]/span[1]/span[1]/span/span[1]";

    private static final String ABSOLUTE_PATH_RETURN_MINUTE = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[3]/div[2]/span[3]/span[1]/span/span[1]";

    private static final String ABSOLUTE_PATH_RETURN_HOUR = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[3]/div[2]/span[1]/span[1]/span/span[1]";

    private static final String ID_DROPDOWN_PICKUP_HOUR = "select2-pickup_time_hours-pa-results";

    private static final String CLASS_NAME_PICKUP_HOUR = "select2-results__option";

    private static final String CLASS_NAME_PICKUP_MINUTE = "select2-results__option";

    private static final String CLASS_NAME_RETURN_HOUR = "select2-results__option";

    private static final String CLASS_NAME_RETURN_MINUTE = "select2-results__option";

    private static final String ID_DROPDOWN_PICKUP_MINUTE = "select2-pickup_time_minutes-th-results";

    private static final String ID_DROPDOWN_RETURN_HOUR = "select2-pickup_time_hours-pa-results";

    private static final String ID_DROPDOWN_RETURN_MINUTE = "select2-pickup_time_minutes-th-results";

    private static final String ABSOLUTE_PATH_INPUT_DRIVER_AGE = "/html/body/div[1]/div/section[1]/form/fieldset[2]/p/input[2]";

    private static final String ABSOLUTE_PATH_FIND_CAR_BUTTON = "/html/body/div[1]/div/section[1]/form/footer/button";

    private static final String CLASS_NAME_FEEDBACK_MESSAGE = "feedback--is_error";

    private static final String ABSOLUTE_PATH_PICKUP_PREV = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[2]/div[2]/div/div/a[1]";

    private static final String ABSOLUTE_PATH_PICKUP_NEXT = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[1]/div[2]/div[2]/div/div/a[2]";

    private static final String ABSOLUTE_PATH_RETURN_PREV = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[2]/div[2]/div/div/a[1]";

    private static final String ABSOLUTE_PATH_RETURN_NEXT = "/html/body/div[1]/div/section[1]/form/fieldset[1]/div[2]/div[2]/div[2]/div/div/a[2]";

    @FindBy(className = CLASS_NAME_CALENDAR)
    private WebElement datePickUpCalendar;

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_CALENDAR)
    private WebElement pickupCalendar;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_CALENDAR)
    private WebElement returnCalendar;

    @FindBy(className = CLASS_NAME_CURRENT_DAY)
    private WebElement currentDatePickerDay;

    private List<WebElement> datesPickerDay = webDriver.findElements(By.xpath(CLASS_NAME_DAY));

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_MONTH)
    private WebElement datePickupMonth;

    @FindBy(xpath = ABSOLUTE_PATH_PICKUP_YEAR)
    private WebElement datePickupYear;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_MONTH)
    private WebElement dateReturnMonth;

    @FindBy(xpath = ABSOLUTE_PATH_RETURN_YEAR)
    private WebElement dateReturnYear;

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

        String chosenMonth = datePickupMonth.getText();
        int chosenYear = Integer.parseInt(datePickupYear.getText());

        while (true) {
            if (Integer.parseInt(criteria.getYearPickup()) < chosenYear) {
                pickupCalendar.findElement(By.xpath(ABSOLUTE_PATH_PICKUP_PREV)).click();
                chosenYear = Integer.parseInt(datePickupYear.getText());
            } else if (Integer.parseInt(criteria.getYearPickup()) > chosenYear) {
                pickupCalendar.findElement(By.xpath(ABSOLUTE_PATH_PICKUP_NEXT)).click();
                chosenYear = Integer.parseInt(datePickupYear.getText());
            } else {
                if (findIndex(MONTHS, criteria.getMonthPickup()) < findIndex(MONTHS, chosenMonth)) {
                    pickupCalendar.findElement(By.xpath(ABSOLUTE_PATH_PICKUP_PREV)).click();
                    chosenMonth = datePickupMonth.getText();
                } else if (findIndex(MONTHS, criteria.getMonthPickup()) > findIndex(MONTHS, chosenMonth)) {
                    pickupCalendar.findElement(By.xpath(ABSOLUTE_PATH_PICKUP_NEXT)).click();
                    chosenMonth = this.datePickupMonth.getText();
                } else {
                    break;
                }
            }
        }

        System.out.println("-----num elem------");
        System.out.println(pickupCalendar.findElements(By.className(CLASS_NAME_DAY)));

        pickupCalendar.findElements(By.className(CLASS_NAME_DAY)).stream()
                .filter(e -> e.getText().equals(String.valueOf(criteria.getDayPickup())))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage chooseReturnDate(CarDestinationCriteria criteria) {
        logger.info("Choose return date");

        String chosenMonth = dateReturnMonth.getText();
        int chosenYear = Integer.parseInt(dateReturnYear.getText());

        while (true) {
            if (Integer.parseInt(criteria.getYearReturn()) < chosenYear) {
                returnCalendar.findElement(By.xpath(ABSOLUTE_PATH_RETURN_PREV)).click();
                chosenYear = Integer.parseInt(dateReturnYear.getText());
            } else if (Integer.parseInt(criteria.getYearReturn()) > chosenYear) {
                returnCalendar.findElement(By.xpath(ABSOLUTE_PATH_RETURN_NEXT)).click();
                chosenYear = Integer.parseInt(dateReturnYear.getText());
            } else {
                if (findIndex(MONTHS, criteria.getMonthReturn()) < findIndex(MONTHS, chosenMonth)) {
                    returnCalendar.findElement(By.xpath(ABSOLUTE_PATH_RETURN_PREV)).click();
                    chosenMonth = dateReturnMonth.getText();
                } else if (findIndex(MONTHS, criteria.getMonthReturn()) > findIndex(MONTHS, chosenMonth)) {
                    returnCalendar.findElement(By.xpath(ABSOLUTE_PATH_RETURN_NEXT)).click();
                    chosenMonth = dateReturnMonth.getText();
                } else {
                    break;
                }
            }
        }

        System.out.println("-----num elem------");
        System.out.println(returnCalendar.findElements(By.className(CLASS_NAME_DAY)));

        returnCalendar.findElements(By.className(CLASS_NAME_DAY)).stream()
                .filter(e -> e.getText().equals(criteria.getDayReturn()))
                .forEach(WebElement::click);

        return this;
    }

    public DateQuotePage choosePickupTime(CarDestinationCriteria criteria) {
        logger.info("Choose pickup time");

        pickupHour.click();

        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLASS_NAME_PICKUP_HOUR)));

        List<WebElement> dropdownPickupHour = webDriver.findElements(By.className(CLASS_NAME_PICKUP_HOUR));

        for (WebElement element : dropdownPickupHour) {
            if (element.getText().equals(criteria.getHourPickup())) {
                element.click();
                break;
            }
        }

        pickupMinute.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLASS_NAME_PICKUP_MINUTE)));

        List<WebElement> dropdownPickupMinute = webDriver.findElements(By.className(CLASS_NAME_PICKUP_MINUTE));

        for (WebElement element : dropdownPickupMinute) {
            if (element.getText().equals(criteria.getMinutePickup())) {
                element.click();
                break;
            }
        }

        return this;
    }

    public DateQuotePage chooseReturnTime(CarDestinationCriteria criteria) {
        logger.info("Choose return time");

        returnHour.click();

        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLASS_NAME_RETURN_HOUR)));

        List<WebElement> dropdownReturnHour = webDriver.findElements(By.className(CLASS_NAME_RETURN_HOUR));

        for (WebElement element : dropdownReturnHour) {
            if (element.getText().equals(criteria.getHourReturn())) {
                element.click();
                break;
            }
        }

        returnMinute.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLASS_NAME_RETURN_MINUTE)));

        List<WebElement> dropdownReturnMinute = webDriver.findElements(By.className(CLASS_NAME_RETURN_MINUTE));

        for (WebElement element : dropdownReturnMinute) {
            if (element.getText().equals(criteria.getMinuteReturn())) {
                element.click();
                break;
            }
        }

        return this;
    }

    public String getErrorMessage() {

        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLASS_NAME_FEEDBACK_MESSAGE)));

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
