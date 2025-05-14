package com.web.factories;

import com.web.enums.ConfigProperties;
import com.web.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverOptionsFactory {

    private DriverOptionsFactory(){}

    public static ChromeOptions chromeOptions(String version){
        ChromeOptions options = new ChromeOptions();
        if(PropertyUtils.get(ConfigProperties.HEADLESS).equalsIgnoreCase("yes")){
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        if (!version.equalsIgnoreCase("latest")) { // Only set version if not "latest"
            options.setCapability("browserVersion", version);
        }
        return options;
    }

    public static FirefoxOptions firefoxOptions(String version){
        FirefoxOptions options = new FirefoxOptions();
        if (PropertyUtils.get(ConfigProperties.HEADLESS).equalsIgnoreCase("yes")) {
            options.addArguments("-headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        }
        if (!version.equalsIgnoreCase("latest")) { // Only set version if not "latest"
            options.setCapability("browserVersion", version);
        }
        return options;
    }

    public static EdgeOptions edgeOptions(String version){
        EdgeOptions options = new EdgeOptions();
        if (PropertyUtils.get(ConfigProperties.HEADLESS).equalsIgnoreCase("yes")) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        if (!version.equalsIgnoreCase("latest")) { // Only set version if not "latest"
            options.setCapability("browserVersion", version);
        }
        return options;
    }
}
