package com.zestcarrental.test;

import com.zestcarrental.page.DateQuotePage;
import com.zestcarrental.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.*;

public class WebDriverSeleniumTest extends CommonConditions {

    private static final int PICKUP_DAY = 17;
    private static final int RETURN_DAY = 28;
    private static final String PICKUP_MONTH = MONTHS[2];
    private static final String RETURN_MONTH = MONTHS[2];
    private static final int PICKUP_YEAR = 2020;
    private static final int RETURN_YEAR = 2020;

    @Test
    public void incorrectSearchForLocation() {
        String url = new HomePage(driver)
                .openPage()
                .searchForLocation(incorrectLocation)
                .getCurrentUrl();
        Assert.assertEquals(url, HOMEPAGE_URL);
    }

    @Test
    public void longRentalDuration() {
        DateQuotePage page = new HomePage(driver)
                .openPage()
                .searchForLocation(correctLocation);
        String quoteDateUrl = page.getCurrentUrl();
        String afterFindCarUrl = page.
                choosePickupDate(PICKUP_DAY, PICKUP_MONTH, PICKUP_YEAR).
                chooseReturnDate(RETURN_DAY, RETURN_MONTH, RETURN_YEAR).
                choosePickupTime(0, 0).
                chooseReturnTime(0, 0).
                findCar().getCurrentUrl();

        Assert.assertEquals(quoteDateUrl, afterFindCarUrl);
    }

}
