package com.web.pages;

import com.web.enums.WaitStrategy;
import com.web.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;


public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
    }

    protected void sendKeys(By by, String text, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(text);
    }

    protected String getText(By by, WaitStrategy waitStrategy){
       return ExplicitWaitFactory.performExplicitWait(by, waitStrategy).getText();
    }

}
