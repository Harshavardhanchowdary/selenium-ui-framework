package com.web.utils;

import com.web.constants.FrameworkConstants;
import com.web.enums.ConfigProperties;
import com.web.exceptions.FrameworkException;
import com.web.exceptions.InvalidPropertyFilePathException;
import com.web.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadProperties {

    private static final Map<String, String> CONFIG_MAP = new HashMap<>();
    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigPropertiesFilePath());
            prop.load(file);
            prop.forEach((key, value) -> CONFIG_MAP.put(String.valueOf(key), String.valueOf(value).trim()));
        }catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);
        }

    }

    private ReadProperties() {
    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name '" + key + "' is not found. Please check config.properties file.");
        }
        return CONFIG_MAP.get(key.name().toLowerCase());
    }

    /**
     * Get the property value from the .properties file by supplying the key whose value need to retrieved.
     *
     * @param key Property whose value need to retrieved.
     * @return property value
     * @throws IllegalArgumentException thrown if the provided key is not in .properties file.
     */
    public static String getProp(ConfigProperties key) {

        if (Objects.isNull(key) || Objects.isNull(prop.getProperty(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name '" + key + "' is not found. Please check config.properties file.");
        }
        return prop.getProperty(key.name().toLowerCase()).trim();
    }

}
