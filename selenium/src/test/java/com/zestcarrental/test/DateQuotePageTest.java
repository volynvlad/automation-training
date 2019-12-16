package com.zestcarrental.test;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
import com.zestcarrental.page.HomePage;
import com.zestcarrental.service.CarDestinationCriteriaCreator;
import com.zestcarrental.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.*;


public class DateQuotePageTest extends CommonConditions {

    @Test
    public void bookingReturnBeforePickup() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        String errorMessage = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .choosePickupLocationFromDropdown(criteria)
                .pressGoButton()
                .choosePickupDate(criteria)
                .choosePickupTime(criteria)
                .chooseReturnDate(criteria)
                .chooseReturnTime(criteria)
                .inputDriverAge(user)
                .getErrorMessage();

        Assert.assertEquals(errorMessage, ERROR_MESSAGE_TIME);
    }

    //@Test
    public void bookingPickupBeforeReturn() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        String errorMessage = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .choosePickupLocationFromDropdown(criteria)
                .pressGoButton()
                .choosePickupDate(criteria)
                .choosePickupTime(criteria)
                .chooseReturnDate(criteria)
                .chooseReturnTime(criteria)
                .inputDriverAge(user)
                .getErrorMessage();

        Assert.assertEquals(errorMessage, ERROR_MESSAGE_TIME);
    }

    //@Test
    public void bookingPickupTooLate() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        String errorMessage = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .choosePickupLocationFromDropdown(criteria)
                .pressGoButton()
                .choosePickupDate(criteria)
                .choosePickupTime(criteria)
                .chooseReturnDate(criteria)
                .chooseReturnTime(criteria)
                .inputDriverAge(user)
                .getErrorMessage();

        Assert.assertEquals(errorMessage, ERROR_MESSAGE_BOOK_DATE_ORDER);
    }

    //@Test
    public void bookingPickupAndReturnTooLong() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        String errorMessage = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .choosePickupLocationFromDropdown(criteria)
                .pressGoButton()
                .choosePickupDate(criteria)
                .choosePickupTime(criteria)
                .chooseReturnDate(criteria)
                .chooseReturnTime(criteria)
                .inputDriverAge(user)
                .getErrorMessage();

        Assert.assertEquals(errorMessage, ERROR_MESSAGE_BOOK_TOO_LONG);
    }

    //@Test
    public void driverAgeTooSmall() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        String errorMessage = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .choosePickupLocationFromDropdown(criteria)
                .pressGoButton()
                .choosePickupDate(criteria)
                .choosePickupTime(criteria)
                .chooseReturnDate(criteria)
                .chooseReturnTime(criteria)
                .inputDriverAge(user)
                .getErrorMessage();

        Assert.assertEquals(errorMessage, ERROR_MESSAGE_TOO_SMALL_DRIVER_AGE);
    }
}
