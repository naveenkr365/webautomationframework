package com.web.factories;

import com.web.enums.ConfigProperties;
import com.web.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory() {}

    public static WebDriver initDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;

        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);

        if(browser.equalsIgnoreCase("chrome")){
            if(runmode.equalsIgnoreCase("remote")){
                ChromeOptions options = new ChromeOptions();
                // Remote Execution
                driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), options);
            } else {
                // Local execution
                driver = new ChromeDriver();
            }
        }
        else if (browser.equalsIgnoreCase("firefox")){
            if(runmode.equalsIgnoreCase("remote")){
                FirefoxOptions options = new FirefoxOptions();
                // Remote Execution
                driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), options);
            } else {
                // Local execution
                driver = new FirefoxDriver();
            }
        }

        else if (browser.equalsIgnoreCase("edge")){
            if(runmode.equalsIgnoreCase("remote")){
                EdgeOptions options = new EdgeOptions();
                // Remote Execution
                driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), options);
            } else {
                // Local execution
                driver = new EdgeDriver();
            }
        }

        return driver;
    }


}
