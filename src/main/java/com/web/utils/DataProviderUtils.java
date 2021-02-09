package com.web.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private static List<Map<String, String>> list = new ArrayList<>();

    private DataProviderUtils() {
    }

    @DataProvider
    public static Object[] getData(Method m) {
        String testName = m.getName();
        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails("TESTDATA");
        }
        List<Map<String, String>> iterationList = new ArrayList<>();

        for (Map<String, String> dataMap : list) {
            if (dataMap.get("testname").equalsIgnoreCase(testName)
                    && dataMap.get("execute").equalsIgnoreCase("yes")) {
                iterationList.add(dataMap);
            }
        }

        return iterationList.toArray();
    }
}
