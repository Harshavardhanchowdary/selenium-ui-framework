package com.web.utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils() {
    }

    /**
     * Builds dynamic xpath based on value provided
     * @param xpath Xpath whose value need to be modified ex: '//a[text()="%replaceable%"]
     * @param value value need to be replace with %replaceable%
     * @return returns the xpath ex: '//a[text()="value"]
     */
    public static String getXpath(String xpath, String value){
        return xpath.replace("%replaceable%", value);
    }
}
