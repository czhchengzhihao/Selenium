package com.selenium.iframe;


import com.selenium.log4j.LoggerController;
import com.selenium.webdriver.KeyWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//iframe 切换
public class Switch_Iframe extends KeyWord {
    final static LoggerController log = LoggerController.getLogger(Switch_Iframe.class);

    //根据iframe id 定位
    public static void switchToFrameById(String iframeId) {
        driver.switchTo().frame(iframeId);
        log.info("根据iframe" + iframeId);

    }

    //根据iframe name 定位
    public static void switchToFrameByName(String iframeName) {
        driver.switchTo().frame(iframeName);
        log.info("根据iframe name 定位" + iframeName);
    }

    //根据iframe 下标 定位 0代表该页面的第一个<iframe>标签
    public static void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        log.info("根据iframe 下标 定位" + index);
    }

    //用定位器定位 By.xpth("")等
    public static void switchToIframeByElement(By by) {
        WebElement webElement = driver.findElement(by);
        driver.switchTo().frame(webElement);
        log.info("用定位器定位 By.xpth" + by);
    }


    //返回上一层iframe
    public static void switchToParentIframe() {
        driver.switchTo().parentFrame();
        log.info("返回上一层iframe");
    }

    //返回最外层
    public static void switchToDefaultContentIframe() {
        driver.switchTo().defaultContent();
        log.info("返回最外层");
    }

}
