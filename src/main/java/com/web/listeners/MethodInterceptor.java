package com.web.listeners;

import com.web.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {

        List<IMethodInstance> result = new ArrayList<>();
        List<Map<String, String>> list = ExcelUtils.getTestDetails("RUNMANAGER");

        for (IMethodInstance method : methods) {
            for (Map<String, String> stringStringMap : list) {
                if (stringStringMap.get("execute").equalsIgnoreCase("yes") && method.getMethod().getMethodName().equalsIgnoreCase(stringStringMap.get("testname"))) {
                    method.getMethod().setInvocationCount((int)Double.parseDouble(stringStringMap.get("count")));
                    method.getMethod().setPriority((int)Double.parseDouble(stringStringMap.get("priority")));
                    method.getMethod().setDescription(stringStringMap.get("testdescription"));
                    result.add(method);
                }
            }
        }
        return result;
    }
}
