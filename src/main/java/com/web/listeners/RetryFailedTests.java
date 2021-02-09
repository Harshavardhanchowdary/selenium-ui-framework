package com.web.listeners;

import com.web.enums.ConfigProperties;
import com.web.utils.ReadProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value =false;
        if(ReadProperties.getProp(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            int retries = Integer.parseInt(ReadProperties.getProp(ConfigProperties.FAILEDTESTRETRYCOUNT));
             value = count < retries;
            count++;
        }
        return value;
    }
}
