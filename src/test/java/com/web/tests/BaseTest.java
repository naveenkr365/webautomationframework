package com.web.tests;

import com.web.driver.Driver;
import com.web.reports.ExtentReport;
import org.testng.annotations.*;

import java.io.IOException;


public class BaseTest {

    protected BaseTest() {

    }

    @BeforeMethod
    @Parameters("browser")
    protected void setUp(String browser) throws Exception {
        Driver.initializeDriver(browser);
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
