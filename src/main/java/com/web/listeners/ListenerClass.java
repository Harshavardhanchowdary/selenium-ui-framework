package com.web.listeners;

import com.web.annotations.FrameworkAnnotation;
import com.web.reports.ExtentLogger;
import com.web.reports.ExtentReport;
import org.testng.*;

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
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass("<h3 style=\"color:green;\">" + result.getMethod().getMethodName() + " is Passed.</h3>");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentLogger.fail("<h3 style=\"color:red;\"}>" + result.getMethod().getMethodName() + " is Failed.</h3>");
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip("<h3 style=\"color:yellow;\">" + result.getMethod().getMethodName() + " is Skipped.</h3>");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
         * No Implementations yet
         */
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        /*
         * No Implementations yet
         */

    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * No Implementations yet
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * No Implementations yet
         */

    }
}
