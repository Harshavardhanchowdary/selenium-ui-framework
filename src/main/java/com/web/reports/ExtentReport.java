package com.web.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.web.constants.FrameworkConstants;
import com.web.enums.CategoryType;

import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;


    private ExtentReport() {

    }

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportsPath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("UI AUTOMATION HK");
            spark.config().setDocumentTitle("HK REPORT");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
    }

    public static void createTest(String testCaseName) {
       ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors){
        for(String author: authors){
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories){
        for(CategoryType cat: categories){
            ExtentManager.getExtentTest().assignCategory(cat.toString());
        }
    }
}


