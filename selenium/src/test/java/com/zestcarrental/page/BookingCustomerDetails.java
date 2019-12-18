package com.zestcarrental.page;

import com.zestcarrental.model.User;
import com.zestcarrental.service.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingCustomerDetails extends AbstractPage {

    private static final String ABSOLUTE_PATH_TITLE_SPAN = "/html/body/div[1]/div/section[2]/form/div/div[1]/div[1]/div/div[1]/span/span[1]/span/span[1]";

    private static final String ID_FIRST_NAME = "first_name";

    private static final String ID_LAST_NAME = "last_name";

    private static final String ID_ADDRESS_LINE_1 = "address_line_1";

    private static final String ID_ADDRESS_LINE_2 = "address_line_2";

    private static final String ID_CITY = "city";

    private static final String ID_COUNTRY = "county";

    private static final String ABSOLUTE_PATH_COUNTRY = "/html/body/div[1]/div/section[2]/form/div/div[1]/div[1]/div/div[14]/span/span[1]/span/span[1]";

    private static final String CSS_SELECTOR_COUNTRIES_LI = "li[class='select2-results__option']";

    private static final String ID_LAND_LINE = "land_line";

    private static final String ID_MOBILE = "mobile";

    private static final String ID_CUSTOMER_EMAIL = "customer-email";

    private static final String ID_CUSTOMER_RETYPE_EMAIL = "retype_email";

    private static final String ABSOLUTE_PATH_NEWSLETTER_YES = "/html/body/div[1]/div/section[2]/form/div/div[1]/div[2]/div/div[1]/label[1]/span";

    private static final String ABSOLUTE_PATH_NEWSLETTER_NO = "/html/body/div[1]/div/section[2]/form/div/div[1]/div[2]/div/div[1]/label[2]/span";

    private static final String CLASS_NAME_CONTINUE_TO_PAYMENT = "booking_form__submit button button--solid button--block button--green";


    @FindBy(id = ABSOLUTE_PATH_TITLE_SPAN)
    private WebElement titleSpan;

    @FindBy(id = ID_FIRST_NAME)
    private WebElement firstNameInput;

    @FindBy(id = ID_LAST_NAME)
    private WebElement lastNameInput;

    @FindBy(id = ID_ADDRESS_LINE_1)
    private WebElement addressLineFirstInput;

    @FindBy(id = ID_ADDRESS_LINE_2)
    private WebElement addressLineSecondInput;

    @FindBy(id = ID_CITY)
    private WebElement cityInput;

    @FindBy(id = ID_COUNTRY)
    private WebElement countryInput;

    @FindBy(xpath = ABSOLUTE_PATH_COUNTRY)
    private WebElement countrySpan;

    private List<WebElement> countriesLi = webDriver.findElements(By.cssSelector(CSS_SELECTOR_COUNTRIES_LI));

    @FindBy(id = ID_LAND_LINE)
    private WebElement landLineInput;

    @FindBy(id = ID_MOBILE)
    private WebElement mobileInput;

    @FindBy(id = ID_CUSTOMER_EMAIL)
    private WebElement customerEmailInput;

    @FindBy(id = ID_CUSTOMER_RETYPE_EMAIL)
    private WebElement customerRetypeEmailInput;

    @FindBy(xpath = ABSOLUTE_PATH_NEWSLETTER_YES)
    private WebElement yesNewsletterSpan;

    @FindBy(xpath = ABSOLUTE_PATH_NEWSLETTER_NO)
    private WebElement noNewsletterSpan;

    @FindBy(className = CLASS_NAME_CONTINUE_TO_PAYMENT)
    private WebElement continueToPayment;

    public BookingCustomerDetails(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public BookingCustomerDetails openPage() {
        logger.info("Open booking customer details page");

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public BookingCustomerDetails fillForm(User user) {
        logger.info("Fill customer details form");

        titleSpan.click();
        titleSpan.findElement(By.cssSelector("span[title='" + user.getTitleType() +  " ']")).click();

        Helper.clickAndSend(firstNameInput, user.getFirstName());


        Helper.clickAndSend(lastNameInput, user.getLastName());

        Helper.clickAndSend(addressLineFirstInput, user.getAddressLineFirst());

        Helper.clickAndSend(addressLineSecondInput, user.getAddressLineSecond());

        Helper.clickAndSend(cityInput, user.getCity());

        Helper.clickAndSend(countryInput, user.getCountry());

        countrySpan.click();
        countriesLi.stream().filter(e -> e.getText().equals(String.valueOf(user.getCountry()))).forEach(WebElement::click);

        Helper.clickAndSend(landLineInput, user.getTelephoneNumber());

        Helper.clickAndSend(mobileInput, user.getMobileNumber());

        Helper.clickAndSend(customerEmailInput, user.getEmail());

        Helper.clickAndSend(customerRetypeEmailInput, user.getEmail());

        noNewsletterSpan.click();

        return this;
    }

    public BookingPagePayment continueToPayment() {
        logger.info("Continue to payment");

        continueToPayment.click();

        return new BookingPagePayment(webDriver);
    }
}
