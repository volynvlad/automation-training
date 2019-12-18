package com.zestcarrental.test;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
import com.zestcarrental.page.HomePage;
import com.zestcarrental.service.CarDestinationCriteriaCreator;
import com.zestcarrental.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.BOOKING_EXTRAS_URL;
import static com.zestcarrental.util.StringUtils.ERROR_MESSAGE_TOO_SMALL_DRIVER_AGE;

public class BookingPageExtrasTest extends CommonConditions {
    @Test
    public void correctAppearsOnBookingPageExtras() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        int carNumber = 1;

        String currentUrl = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .choosePickupLocationFromDropdown(criteria)
                .pressGoButton()
                .choosePickupDate(criteria)
                .choosePickupTime(criteria)
                .chooseReturnDate(criteria)
                .chooseReturnTime(criteria)
                .inputDriverAge(user)
                .findCar()
                .bookCar(carNumber)
                .getCurrentUrl();

        Assert.assertEquals(currentUrl, BOOKING_EXTRAS_URL);
    }
}
