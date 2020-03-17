package com.selenium.find_elenment;

import com.selenium.log4j.LoggerController;
import com.selenium.webdriver.KeyWord;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


//封装元素加载等待时间
public class WebElementUtil extends KeyWord {
    final static LoggerController log = LoggerController.getLogger(WebElementUtil.class);

    //findElement
    public static WebElement findElement(final By by) {
        WebElement webelement = null;
        try {
            webelement = new WebDriverWait(driver, 20).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                    return driver.findElement(by);
                }
            });
        } catch (Exception e) {
            log.info("元素：" + by + "查找超时！！！");
            e.printStackTrace();
        }
        return webelement;
    }

    //findElements
    public static List<WebElement> findElements(final By by) {
        List<WebElement> WebElement = null;
        try {
            WebElement = new WebDriverWait(driver, 20).until(new ExpectedCondition<List<WebElement>>() {
                @NullableDecl
                public List<WebElement> apply(WebDriver webDriver) {
                    return driver.findElements(by);
                }
            });
        } catch (Exception e) {
            log.info("元素：" + by + "查找超时！！！");
            e.printStackTrace();
        }
        return WebElement;
    }

}
