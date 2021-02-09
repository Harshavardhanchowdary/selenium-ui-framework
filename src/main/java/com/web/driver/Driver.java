package com.web.driver;

import com.web.enums.ConfigProperties;
import com.web.exceptions.BrowserInvocationFailedException;
import com.web.factories.DriverFactory;
import com.web.utils.ReadProperties;


import java.net.MalformedURLException;

import java.util.Objects;

/**
 * <p>
 * Driver class is responsible for initializing and terminating browser instance.
 * </p>
 * <p>
 * It is also responsible for setting
 * the driver variable to DriverManager which handles the thread safety of the webdriver instance.
 * </p>
 * <p>
 * Feb 2, 2021
 *
 * @author kavurichowdary
 * @version 1.0
 * @see DriverManager
 * @since 1.0
 */

public final class Driver {
    /**
     * Private constructor to avoid external instantiation.
     */
    private Driver() {
    }

    /**
     * Initialize web driver instance.
     *
     * @param browser name of the browser whose instance need to be created.
     */
    public static void initDriver(String browser) {

        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setWebDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Browser Invocation failed. Please check the capabilities.");
            }
            DriverManager.getDriver().get(ReadProperties.getProp(ConfigProperties.URL));

        }


    }

    /**
     * Quits the browser.
     */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
