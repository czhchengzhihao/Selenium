package com.selenium.drivers;

import com.selenium.actions.ActionsUtil;
import com.selenium.find_elenment.WebElementUtil;
import com.selenium.log4j.LoggerController;
import com.selenium.webdriver.KeyWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SeleniumDriversTest {
    final static LoggerController log = LoggerController.getLogger(SeleniumDriversTest.class);

    @Test
    public void open() {
        WebDriver driver = SeleniumDrivers.openBrowser("firefox");
        driver.get("http://116.255.240.233:8089/login");
        ActionsUtil.sendText(By.id("name"), "测试专员");
    }

    @Test
    public void close() {
        log.debug("debug");
        log.error("error");
        log.info("info");
        log.warn("warn");
        //SeleniumDrivers.quit();
    }

}
