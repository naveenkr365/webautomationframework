package com.web.utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils() {}

    public static String getXpath(String path, String value){
        return String.format(path,value);
    }

    public static String getXpath(String path, String value1, String value2){
        return String.format(path,value1, value2);
    }
}
