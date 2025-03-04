package com.web.driver;

import com.web.enums.ConfigProperties;
import com.web.exceptions.BrowserInvocationFailedException;
import com.web.factories.DriverFactory;
import com.web.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver(){}

    public static void initializeDriver(String browser){
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.initDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Unable to Launch Browser.. Check the Driver option");
            }
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
