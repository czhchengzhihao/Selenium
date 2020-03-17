package com.selenium.drivers;

import com.selenium.log4j.LoggerController;
import com.selenium.webdriver.KeyWord;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDrivers extends KeyWord {
    final static LoggerController log = LoggerController.getLogger(SeleniumDrivers.class);

    public static WebDriver openBrowser(String browser) {
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.bin", "D:\\Aanzhuanglujing\\Mozilla Firefox\\firefox.exe");
            log.info("打开浏览器"+browser);
            driver = new FirefoxDriver();
        } else {
            log.info("打开浏览器错误"+browser);
        }
        return driver;
    }

    // 刷新浏览器
    public static void refresh() {
        driver.navigate().refresh();
        log.info("刷新浏览器");
    }

    // 浏览器前进
    public static void forward() {
        driver.navigate().forward();
        log.info("浏览器前进");
    }

    // 浏览器后退
    public static void back() {
        driver.navigate().back();
        log.info("浏览器后退");
    }

    //关闭浏览器  关闭窗口不关闭后台进程
    public static void close() {
        driver.close();
        log.info("关闭浏览器  关闭窗口不关闭后台进程");
    }

    //关闭浏览器  关闭窗口 关闭后台进程
    public static void quit() {
        driver.quit();
        log.info("关闭浏览器  关闭窗口 关闭后台进程");
    }

    //浏览器最大化
    public static void maximize() {
        driver.manage().window().maximize();
        log.info("浏览器最大化");
    }

    //设置浏览器大小
    public static void manage(int x, int y) {
        Dimension dimension = new Dimension(x, y);
        driver.manage().window().setSize(dimension);
        log.info("设置浏览器大小");
    }

    //获取当前页面URL
    public static void getUrl(int x, int y) {
        driver.getCurrentUrl();
        log.info("获取当前页面URL");
    }

    //获取当前页面Title
    public static void getTitle(int x, int y) {
        driver.getTitle();
        log.info("获取当前页面Title");
    }
}
