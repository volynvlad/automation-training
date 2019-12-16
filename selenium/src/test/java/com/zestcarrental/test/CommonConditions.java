package com.zestcarrental.test;

import com.zestcarrental.driver.DriverSingleton;
import com.zestcarrental.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() { driver = DriverSingleton.getDriver(); }

    @AfterMethod(alwaysRun = true)
    public void browserTurnDown() { DriverSingleton.closeDriver(); }
}
