package com.web.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.web.enums.ConfigProperties;
import com.web.utils.ReadProperties;
import com.web.utils.ScreenShotUtils;


public final class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void pass(Markup message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void pass(String message, boolean captureScreenShot) {
        if (captureScreenShot &&
                ReadProperties.getProp(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }

    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void fail(Markup message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void fail(String message, boolean captureScreenShot) {
        if (captureScreenShot &&
                ReadProperties.getProp(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        } else {
            fail(message);
        }

    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void skip(Markup message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void skip(String message, boolean captureScreenShot) {
        if (captureScreenShot &&
                ReadProperties.getProp(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        } else {
            skip(message);
        }

    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    public static void warning(String message) {
        ExtentManager.getExtentTest().warning(message);
    }



}
