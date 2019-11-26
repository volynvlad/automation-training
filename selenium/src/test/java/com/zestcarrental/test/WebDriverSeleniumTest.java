package com.zestcarrental.test;

import com.zestcarrental.page.DateQuotePage;
import com.zestcarrental.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.*;

public class WebDriverSeleniumTest extends CommonConditions {

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
        String afterFindCarUrl = page.choosePickupDate().chooseReturnDate().findCar().getCurrentUrl();

        Assert.assertEquals(quoteDateUrl, afterFindCarUrl);
    }

}
