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

    public static WebDriver initDriver(String browser, String version) throws MalformedURLException {
        WebDriver driver = null;
        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
        String gridUrl = PropertyUtils.get(ConfigProperties.GRIDURL); // Update with EC2 Public IP if needed

        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                driver = new RemoteWebDriver(new URL(gridUrl), DriverOptionsFactory.chromeOptions(version));
            } else {
                driver = new ChromeDriver(DriverOptionsFactory.chromeOptions(version));
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
                driver = new RemoteWebDriver(new URL(gridUrl), DriverOptionsFactory.firefoxOptions(version));
            } else {
                driver = new FirefoxDriver(DriverOptionsFactory.firefoxOptions(version));
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            if (runmode.equalsIgnoreCase("remote")) {
                driver = new RemoteWebDriver(new URL(gridUrl), DriverOptionsFactory.edgeOptions(version));
            } else {
                driver = new EdgeDriver(DriverOptionsFactory.edgeOptions(version));
            }
        }

        return driver;
    }
}
