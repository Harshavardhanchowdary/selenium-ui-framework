package com.web.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private static ThreadLocal<ExtentTest> et = new ThreadLocal<>();

    private ExtentManager() {
    }

     static ExtentTest getExtentTest() {
        return et.get();
    }

     static void setExtentTest(ExtentTest test) {
        et.set(test);
    }

    public static void unload() {
        et.remove();
    }
}
