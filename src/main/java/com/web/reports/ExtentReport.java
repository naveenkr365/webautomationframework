package com.web.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.web.constants.FrameworkConstants;
import com.web.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilepath());
            extent.attachReporter(spark);
            spark.config().setDocumentTitle("HRM Testing Report");
            spark.config().setReportName("Automation Testing");
        }
    }

    public static void createTest(String testName){
        ExtentManager.setExtentTest(extent.createTest(testName));
    }

    public static void flushReports() {
        if(Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilepath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAuthors(String[] author){
        for(String temp : author){
            ExtentManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addCategories(CategoryType[] categories){
        for(CategoryType temp : categories){
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }

}
