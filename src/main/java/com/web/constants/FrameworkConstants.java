package com.web.constants;

import com.web.enums.ConfigProperties;
import com.web.utils.ReadProperties;

public final class FrameworkConstants {

    private static final String TEST_RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROME_DRIVER_PATH = TEST_RESOURCE_PATH + "/executables/chromedriver";
    private static final String FIREFOX_DRIVER_PATH = TEST_RESOURCE_PATH + "/executables/geckodriver";
    private static final String CONFIG_PROPERTIES_FILE_PATH = TEST_RESOURCE_PATH + "/config/config.properties";
    private static final int EXPLICIT_WAIT = 10;
    private static final String EXTENT_REPORTS_PATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static  final  String TEST_DATA_FILE  = TEST_RESOURCE_PATH+"/testData/TestData.xlsx";
    private static String EXTENT_REPORT_FILE_PATH = "";

    private FrameworkConstants() {

    }

    public static String getFirefoxDriverPath() {
        return FIREFOX_DRIVER_PATH;
    }

    public static String getTestDataFile() {
        return TEST_DATA_FILE;
    }

    public static String getChromeDriverPath() {
        return CHROME_DRIVER_PATH;
    }

    public static String getConfigPropertiesFilePath() {
        return CONFIG_PROPERTIES_FILE_PATH;
    }

    public static String getExtentReportsPath() {

        if (EXTENT_REPORT_FILE_PATH.isEmpty()
                && ReadProperties.getProp(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            EXTENT_REPORT_FILE_PATH = EXTENT_REPORTS_PATH + "/" + System.currentTimeMillis() + "index.htm";
        } else {
            EXTENT_REPORT_FILE_PATH = EXTENT_REPORTS_PATH + "/index.html";
        }
        return EXTENT_REPORT_FILE_PATH;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }
}
