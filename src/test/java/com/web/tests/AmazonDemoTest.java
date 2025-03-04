package com.web.tests;

import com.web.annotations.FrameworkAnnotations;
import com.web.enums.CategoryType;
import com.web.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonDemoTest extends BaseTest{

    private AmazonDemoTest(){}

    @FrameworkAnnotations(author = {"Naveen"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    @Test
    public void amazonTest(Map<String,String> data){
        String title = new AmazonHomePage().clickHamburger().clickComputer()
                .clickOnSubMenuItem(data.get("menutext")).getTitle();
        Assertions.assertThat(title)
                .isNotNull()
                .isNotEmpty()
                .isNotBlank();
    }
}
