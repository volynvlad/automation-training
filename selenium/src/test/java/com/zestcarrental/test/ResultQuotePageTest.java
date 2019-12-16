package com.zestcarrental.test;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
import com.zestcarrental.page.HomePage;
import com.zestcarrental.page.ResultQuotePage;
import com.zestcarrental.service.CarDestinationCriteriaCreator;
import com.zestcarrental.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.*;

public class ResultQuotePageTest extends CommonConditions {

    @Test
    public void changeCurrency() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        User user = UserCreator.withCredentialsFromProperty();

        ResultQuotePage page = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .searchForLocation(criteria)
                .choosePickupDate(criteria)
                .choosePickupTime(criteria)
                .chooseReturnDate(criteria)
                .chooseReturnTime(criteria)
                .inputDriverAge(user)
                .findCar();

        Assert.assertEquals(page.getCurrentUrl(), QUOTE_RESULTS_URL);
        String currentCurrency = page.currentCurrency();

        String afterChange = page
                .chooseCurrency(currentCurrency.equals(CURRENCY_GBP) ? CURRENCY_EUR : CURRENCY_GBP)
                .currentCurrency();

        Assert.assertTrue(currentCurrency.equals(CURRENCY_EUR) ? afterChange.equals(CURRENCY_GBP) : afterChange.equals(CURRENCY_EUR));
    }
}
