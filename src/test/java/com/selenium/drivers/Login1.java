package com.selenium.drivers;

import com.selenium.excel.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Login1 {

    private WebDriver driver;

    /*
     * 打开浏览器
     * */
    @BeforeClass(description = "打开浏览器")
    public void open() {
        System.setProperty("webdriver.firefox.bin", "D:\\Aanzhuanglujing\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    @Test(description = "打开登录页面")
    public void loginPage() throws InterruptedException {
        driver.get("http://116.255.240.233:8089/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String openResult = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
        //System.out.println(openResult);
        Assert.assertEquals("管理员登录", openResult);

    }

    /*
     * 参数化
     * */
    @DataProvider
    public Object[] getParam() throws IOException {
        Excel excel=new Excel();
        return excel.getExcelUtil("D:\\xx.xlsx", 0, 1, 0);
    }

    @Test(description = "登录操作", dependsOnMethods = "loginPage", dataProvider = "getParam")
    public void loginOperation(String name, String pwd) throws InterruptedException {
        //在每次输入登录数据时清空输入框
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("pwd")).clear();
        //System.out.println(name);
        //System.out.println(pwd);
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("pwd")).sendKeys(pwd);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        String loginResult = driver.findElement(By.xpath("//*[@id=\"app\"]/header/div[1]/a[2]/span")).getText();
        //System.out.println(loginResult);
        Assert.assertEquals("智慧环卫", loginResult);
    }

    /*
     * AfterMethod在每个方法开始之后运行
     */
    @AfterMethod(description = "等待时间")
    public void wait3s() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*
     *关闭浏览器，关闭后台进程
     */
    @AfterClass(description = "关闭浏览器")
    public void close() {
        driver.quit();
    }


}
