package com.zestcarrental.test;

import com.zestcarrental.page.DateQuotePage;
import com.zestcarrental.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumTest {

    private static final String ZEST_CAR_RENTAL_URL = "https://www.zestcarrental.com/";

    private static final String incorrectLocation = "Grodno";
    private static final String correctLocation = "Berlin";



    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void incorrectSearchForLocation() {
        String url = new HomePage(webDriver)
                .openPage()
                .searchForLocation(incorrectLocation)
                .getCurrentUrl();
        Assert.assertEquals(url, ZEST_CAR_RENTAL_URL);
    }

    @Test
    public void longRentalDuration() {
        DateQuotePage page = new HomePage(webDriver)
                .openPage()
                .searchForLocation(correctLocation);
        String quoteDateUrl = page.getCurrentUrl();
        String afterFindCarUrl = page.choosePickupDate().chooseReturnDate().findCar().getCurrentUrl();

        Assert.assertEquals(quoteDateUrl, afterFindCarUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTurnDown() {
        webDriver.quit();
        webDriver = null;
    }

}
