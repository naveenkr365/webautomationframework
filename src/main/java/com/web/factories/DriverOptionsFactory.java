package com.web.factories;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverOptionsFactory {

    private DriverOptionsFactory(){}

    public static ChromeOptions chromeOptions(String version){
        ChromeOptions options = new ChromeOptions();
        if (!version.equalsIgnoreCase("latest")) { // Only set version if not "latest"
            options.setCapability("browserVersion", version);
        }
        return options;
    }

    public static FirefoxOptions firefoxOptions(String version){
        FirefoxOptions options = new FirefoxOptions();
        if (!version.equalsIgnoreCase("latest")) { // Only set version if not "latest"
            options.setCapability("browserVersion", version);
        }
        return options;
    }

    public static EdgeOptions edgeOptions(String version){
        EdgeOptions options = new EdgeOptions();
        if (!version.equalsIgnoreCase("latest")) { // Only set version if not "latest"
            options.setCapability("browserVersion", version);
        }
        return options;
    }
}
