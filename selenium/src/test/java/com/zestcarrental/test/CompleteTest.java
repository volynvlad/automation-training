package com.zestcarrental.test;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
import com.zestcarrental.page.HomePage;
import com.zestcarrental.service.CarDestinationCriteriaCreator;
import com.zestcarrental.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.ERROR_MESSAGE_VALID_CARD;

public class CompleteTest extends CommonConditions {
    @Test
    public void completeTest() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        int carNumber = 1;

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
                .findCar()
                .bookCar(carNumber)
                .nextStep()
                .nextStep()
                .fillForm(user)
                .acceptDepositRequirements()
                .nextStep()
                .fillForm(false, user)
                .pressContinue()
                .fillForm(user)
                .continueToPayment()
                .fillForm(user)
                .pressContinue()
                .getErrorMessage();
        Assert.assertEquals(ERROR_MESSAGE_VALID_CARD, errorMessage);
    }
}
