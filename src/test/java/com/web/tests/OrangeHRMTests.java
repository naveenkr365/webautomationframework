package com.web.tests;

import com.web.annotations.FrameworkAnnotations;
import com.web.enums.CategoryType;
import com.web.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest{

    private OrangeHRMTests(){}

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    @Test
    public void loginLogoutTest(Map<String,String> data){
        String actualTitle = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .getTitle();

        Assertions.assertThat(actualTitle)
                .isEqualTo("OrangeHRM");

    }

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test
    public void newTest(Map<String,String> data){
        String actualTitle = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .getTitle();

        Assertions.assertThat(actualTitle)
                .isEqualTo("OrangeHRM");

    }

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    @Test
    public void loginLogoutTest2(Map<String,String> data){
        String actualTitle = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .getTitle();

        Assertions.assertThat(actualTitle)
                .isEqualTo("OrangeHRM");

    }

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test
    public void newTest2(Map<String,String> data){
        String actualTitle = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .getTitle();

        Assertions.assertThat(actualTitle)
                .isEqualTo("OrangeHRM");

    }

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    @Test
    public void loginLogoutTest3(Map<String,String> data){
        String actualTitle = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .getTitle();

        Assertions.assertThat(actualTitle)
                .isEqualTo("OrangeHRM");

    }

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test
    public void newTest3(Map<String,String> data){
        String actualTitle = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .getTitle();

        Assertions.assertThat(actualTitle)
                .isEqualTo("OrangeHRM");

    }

}

