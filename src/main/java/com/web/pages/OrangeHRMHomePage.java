package com.web.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.web.driver.DriverManager;
import com.web.enums.WaitStrategy;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public final class OrangeHRMHomePage extends BasePage {

    private final By profileName = By.xpath("//*[@class='oxd-userdropdown-name']");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickProfile(){
        click(profileName, WaitStrategy.CLICKABLE, "Profile Link");
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        click(linkLogout, WaitStrategy.CLICKABLE, "LogOut");
        return new OrangeHRMLoginPage();
    }

}
