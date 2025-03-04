package com.web.tests;

import com.web.driver.Driver;
import com.web.driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.Objects;

public final class HomepageTest extends BaseTest{

    private HomepageTest(){

    }

    /*
    1. Validate title is not null
    2. validate title contains OrangeHRM
    3. Validate Length is greater than 5 and less than 15

     */

    @Test
    public void test1() {
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(Objects.nonNull(title),"Title is Null");
        Assert.assertTrue(title.toLowerCase().contains("orangehrm"));
        Assert.assertTrue(title.length()>5);
        Assert.assertTrue(title.length()<15);

    }

    @Test
    public void test2() {
        String title = DriverManager.getDriver().getTitle();
        Assertions.assertThat(title)
                .isNotNull()
                .containsIgnoringCase("orangehrm")
                .hasSizeGreaterThan(5)
                .hasSizeLessThan(15);

    }
}
