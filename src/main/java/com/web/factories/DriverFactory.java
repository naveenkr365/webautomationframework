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
        String gridUrl = "http://localhost:4444/wd/hub"; // Update with EC2 Public IP if needed

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (!version.equalsIgnoreCase("latest")) { // Only set version if not "latest"
                options.setCapability("browserVersion", version);
            }
            if (runmode.equalsIgnoreCase("remote")) {
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (!version.equalsIgnoreCase("latest")) {
                options.setCapability("browserVersion", version);
            }
            if (runmode.equalsIgnoreCase("remote")) {
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            } else {
                driver = new FirefoxDriver();
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (!version.equalsIgnoreCase("latest")) {
                options.setCapability("browserVersion", version);
            }
            if (runmode.equalsIgnoreCase("remote")) {
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            } else {
                driver = new EdgeDriver();
            }
        }

        return driver;
    }
}
