package com.selenium.uploadFile;

import com.selenium.webdriver.KeyWord;
import org.openqa.selenium.By;

public class UploadFileUtil extends KeyWord {

    /**
     * 上传文件
     * filePath  文件路劲
     */
    public static void uploadFile(By locator, String filePath) {
        driver.findElement(locator).sendKeys(filePath);
    }
}
