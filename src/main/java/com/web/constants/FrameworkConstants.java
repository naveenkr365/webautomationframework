package com.web.constants;

import com.web.enums.ConfigProperties;
import com.web.utils.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){

    }

    private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
    private static final String EXCELPATH = RESOURCEPATH+"/excel/testdata.xlsx";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
    private static final String RUNMANAGERSHEET = "RUNMANAGER";
    private static final String ITERATIONDATASHEET = "DATA";
    private static String extentReportFilePath="";
    private static final int EXPLICITWAIT = 10;

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }

    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }

    public static String getRunManagerSheet(){
        return RUNMANAGERSHEET;
    }

    public static String getIterationDataSheet(){
        return ITERATIONDATASHEET;
    }

    public static String getExtentReportFilepath() {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath(){
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
        }
        else{
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }
    }

    public static String getExcelPath(){
        return EXCELPATH;
    }



}
