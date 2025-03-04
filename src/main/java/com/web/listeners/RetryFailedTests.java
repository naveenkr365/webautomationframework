package com.web.listeners;

import com.web.enums.ConfigProperties;
import com.web.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        try {
            if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
                value = count < retries;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
