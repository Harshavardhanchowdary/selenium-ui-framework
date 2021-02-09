package com.web.pages;


import com.web.enums.WaitStrategy;
import com.web.reports.ExtentLogger;
import org.openqa.selenium.By;

public final class HomePage extends BasePage {

    public final By textBoxSearch = By.id("search_query_top");
    public final By textWarning = By.xpath("//div[@id ='center_column']//p[contains(@class,'alert-warning')]");

    public HomePage enterSearch(String searchKey){

       sendKeys(textBoxSearch,searchKey, WaitStrategy.PRESENCE);
        ExtentLogger.pass("Searched with text",true);

       return this;
    }

    public String getWarningText(){
        ExtentLogger.pass("Successfully got the warning text.",true);
        return getText(textWarning,WaitStrategy.VISIBLE);
    }
}
