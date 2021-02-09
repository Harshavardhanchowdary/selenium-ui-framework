package com.web.tests;


import com.aventstack.extentreports.ExtentTest;
import com.web.driver.Driver;

import com.web.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.util.Map;


public class BaseTest {

    protected BaseTest() {

    }

    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        Map<String, String> map = (Map<String, String>)data[0];
        Driver.initDriver(map.get("browser"));

    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
