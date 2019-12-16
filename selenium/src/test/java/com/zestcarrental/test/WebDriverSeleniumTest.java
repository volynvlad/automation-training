package com.zestcarrental.test;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.page.DateQuotePage;
import com.zestcarrental.page.HomePage;
import com.zestcarrental.service.CarDestinationCriteriaCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.*;

public class WebDriverSeleniumTest extends CommonConditions {


    public void longRentalDuration() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        DateQuotePage page = new HomePage(driver)
                .openPage()
                .searchForLocation(criteria);
        String quoteDateUrl = page.getCurrentUrl();
        String afterFindCarUrl = page.
                choosePickupDate(criteria).
                chooseReturnDate(criteria).
                choosePickupTime(criteria).
                chooseReturnTime(criteria).
                findCar().getCurrentUrl();

        Assert.assertEquals(quoteDateUrl, afterFindCarUrl);
    }

}
