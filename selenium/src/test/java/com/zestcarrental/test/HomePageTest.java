package com.zestcarrental.test;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.page.HomePage;
import com.zestcarrental.service.CarDestinationCriteriaCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.QUOTE_DATES_URL;

public class HomePageTest extends CommonConditions {

    @Test
    public void incorrectSearchForLocation() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        boolean isNoLocationFound = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .isNoLocation();
        Assert.assertTrue(isNoLocationFound);
    }

    @Test
    public void withReturnLocationChoice() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        String url = new HomePage(driver)
                .openPage()
                .writePickupLocation(criteria)
                .pressReturnLabel()
                .chooseReturnLocation(criteria)
                .searchForLocation(criteria)
                .getCurrentUrl();

        Assert.assertEquals(url, QUOTE_DATES_URL);
    }
}
