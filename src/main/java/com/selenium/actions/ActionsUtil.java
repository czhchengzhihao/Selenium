package com.selenium.actions;


import com.selenium.find_elenment.WebElementUtil;
import com.selenium.log4j.LoggerController;
import com.selenium.webdriver.KeyWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ActionsUtil extends KeyWord {
    final static LoggerController log = LoggerController.getLogger(ActionsUtil.class);

    //点击动作click
    public static void click(By by) {
        WebElementUtil.findElement(by).click();
        log.info("点击"+by);
    }

    //文本框输入
    public static void sendText(By by, String text) {
        WebElementUtil.findElement(by).sendKeys(text);
        log.info("文本框输入"+by);
    }

    //清空文本框
    public static void clear(By by) {
        WebElementUtil.findElement(by).clear();
        log.info("清空文本框"+by);
    }

    //获取文本框中内容
    public static String getText(By by) {
        String text = WebElementUtil.findElement(by).getText();
        log.info("获取文本框中内容"+by);
        return text;
    }

    //获取多个内容
    public static ArrayList getTexts(By by) {
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = WebElementUtil.findElements(by);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            arrayList.add(text);
            log.info("湖区多个内容"+by);
        }
        return arrayList;
    }

    // 鼠标悬浮指定元素并点击
    public static void moveTo(By by) {
        Actions actions = new Actions(driver);
        WebElement webElement = WebElementUtil.findElement(by);
        actions.moveToElement(webElement).perform();
        log.info("鼠标悬浮并点击"+by);
    }


    // 鼠标右键点击
    public static void RightClick(By by) {
        Actions actions = new Actions(driver);
        WebElement webElement = WebElementUtil.findElement(by);
        actions.contextClick(webElement).perform();
        log.info("鼠标右键点击"+by);
    }


    //鼠标双击
    public static void doubleClick( By by) {
        Actions actions = new Actions(driver);
        WebElement webElement = WebElementUtil.findElement(by);
        actions.doubleClick(webElement).perform();
        log.info("鼠标双击"+by);
    }

}
