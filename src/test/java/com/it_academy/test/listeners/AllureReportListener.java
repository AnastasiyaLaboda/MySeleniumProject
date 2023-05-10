package com.it_academy.test.listeners;

import com.it_academy.test.BaseTest;
import framework.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).;
        if (driver instanceof WebDriver) {
            takeScreenshot(driver);
        }
    }

    private void takeScreenshot(WebDriver driver) {
        Allure.addAttachment("Screenshot of failed step",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
