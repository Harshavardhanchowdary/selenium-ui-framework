package com.web.tests;

import com.web.annotations.FrameworkAnnotation;
import com.web.driver.DriverManager;
import com.web.enums.CategoryType;
import com.web.pages.HomePage;
import com.web.reports.ExtentReport;
import com.web.utils.DataProviderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public final class HomePageTests extends BaseTest {

    private HomePage homePage;

    private HomePageTests() {
        this.homePage = new HomePage();
    } // Restricting object creation from other classes.


    @DataProvider
    public Object[] getData(){
        String[] a ={"Automation","Automation11" };
        return a;
    }

    @FrameworkAnnotation(author = {"Harsha","Vardhan"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void searchFromMyShop(Map<String, String> data) throws InterruptedException {
        String actualTitle = DriverManager.getDriver().getTitle();
        Assert.assertEquals(actualTitle, "My Store");
        assertThat(actualTitle)
                .isNotNull()
                .hasSizeGreaterThan(4)
                .isEqualTo("My Store");
        DriverManager.getDriver().findElement(By.id("search_query_top")).sendKeys(data.get("searchkey"), Keys.ENTER);
        String warningMessage = homePage.getWarningText();
        assertThat(warningMessage)
                .isNotNull()
                .isEqualTo("No results were found for your search \""+ data.get("searchkey")+"\"")
                .hasSizeGreaterThan(5);

    }

    @Test
    public void searchFromMyShopx() throws InterruptedException {

        String actualTitle = DriverManager.getDriver().getTitle();
        Assert.assertEquals(actualTitle, "My Store");
        assertThat(actualTitle)
                .isNotNull()
                .hasSizeGreaterThan(4)
                .isEqualTo("My Store");
        DriverManager.getDriver().findElement(By.id("search_query_top")).sendKeys("Automation x", Keys.ENTER);
        String warningMessage = homePage.getWarningText();
        assertThat(warningMessage)
                .isNotNull()
                .isEqualTo("No results were found for your searchx \"Automation x\"")
                .hasSizeGreaterThan(5);


    }


}

