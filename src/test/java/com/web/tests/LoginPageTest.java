package com.web.tests;

import com.web.driver.DriverManager;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest{

    private LoginPageTest(){
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(DriverManager.getDriver().getTitle());
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(DriverManager.getDriver().getTitle());
    }
}
