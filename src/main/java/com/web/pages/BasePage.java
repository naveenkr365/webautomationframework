package com.web.pages;

import com.web.driver.DriverManager;
import com.web.enums.WaitStrategy;
import com.web.factories.ExplicitWaitFactory;
import com.web.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
        try {
            ExtentLogger.pass(elementName + " is clicked",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
        try {
            ExtentLogger.pass(value + " is entered successfully in " + elementName,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
