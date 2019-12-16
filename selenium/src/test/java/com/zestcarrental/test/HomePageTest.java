package com.zestcarrental.test;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.page.HomePage;
import com.zestcarrental.service.CarDestinationCriteriaCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zestcarrental.util.StringUtils.HOMEPAGE_URL;

public class HomePageTest extends CommonConditions {
    @Test
    public void incorrectSearchForLocation() {
        CarDestinationCriteria criteria = CarDestinationCriteriaCreator.withCredentialsFromProperty();
        String url = new HomePage(driver)
                .openPage()
                .searchForLocation(criteria)
                .getCurrentUrl();
        Assert.assertEquals(url, HOMEPAGE_URL);
    }
}
