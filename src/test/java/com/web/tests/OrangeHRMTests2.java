package com.web.tests;

import com.web.annotations.FrameworkAnnotations;
import com.web.enums.CategoryType;
import com.web.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests2 extends BaseTest{

    private OrangeHRMTests2(){}

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    @Test
    public void loginLogoutTest(){
        String actualTitle = new OrangeHRMLoginPage()
                .enterUsername("Admin").enterPassword("admin123").clickLogin()
                .clickProfile().clickLogout()
                .getTitle();

        Assertions.assertThat(actualTitle)
                .isEqualTo("OrangeHRM");

    }

}

