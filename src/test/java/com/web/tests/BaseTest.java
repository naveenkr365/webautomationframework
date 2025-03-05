package com.web.tests;

import com.web.driver.Driver;
import org.testng.annotations.*;


public class BaseTest {

    protected BaseTest() {

    }

    @BeforeMethod
    @Parameters({"browser", "version"})
    protected void setUp(String browser, String version) throws Exception {
        Driver.initializeDriver(browser, version);
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
