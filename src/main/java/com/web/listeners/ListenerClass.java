package com.web.listeners;

import com.web.annotations.FrameworkAnnotations;
import com.web.reports.ExtentLogger;
import com.web.reports.ExtentReport;
import com.web.utils.BrowserUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
            ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        //ExtentReport.createTest(result.getMethod().getDescription()+ " - " + BrowserUtils.getBrowserName() + " - v" + BrowserUtils.getBrowserVersion());
        ExtentReport.createTest(result.getMethod().getMethodName()+ " - " + BrowserUtils.getBrowserName() + " - v" + BrowserUtils.getBrowserVersion());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class)
                .category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed",true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }
}
