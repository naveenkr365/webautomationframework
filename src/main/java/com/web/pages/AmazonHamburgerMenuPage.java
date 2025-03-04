package com.web.pages;

import com.web.enums.WaitStrategy;
import com.web.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class AmazonHamburgerMenuPage extends BasePage {

    private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
    private  String linkSubMenu = "//a[text()='%s']";

    public AmazonHamburgerMenuPage clickComputer() {
        click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobiles and Computers");
        return this;
    }

    public AmazonLaptopPage clickOnSubMenuItem(String menutext) {
        String newxpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
        click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
        if(menutext.contains("Laptops")) {
            return new AmazonLaptopPage();
        }
        return null;
    }

}
