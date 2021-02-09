package com.web.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class JSONUtils {

    public static Object[] getJSONData(String jsonFilePath)  {

        try {
            HashMap<String, Object> map1 = new ObjectMapper().readValue(new File(jsonFilePath), new TypeReference<HashMap<String, Object>>() {
            });
            return new Object[]{map1};
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[]{};
    }


    public static void main(String[] args)  {
        String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/testData/consfig.json";
        Object[] data = JSONUtils.getJSONData(jsonFilePath);
        Map<String, Object> map = (Map<String, Object>) data[0];
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
