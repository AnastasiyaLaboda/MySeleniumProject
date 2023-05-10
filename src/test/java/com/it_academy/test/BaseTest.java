package com.it_academy.test;

import com.it_academy.test.listeners.AllureReportListener;
import framework.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(AllureReportListener.class)
public class BaseTest {
    @BeforeClass
    public void navigationToHomePage() {
        DriverManager.getWebDriver();
    }

    @AfterClass
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}
