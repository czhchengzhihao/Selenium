package com.selenium.screenShots;

import com.selenium.webdriver.KeyWord;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenShotsUtil extends KeyWord {

    public static void screenShot(WebDriver driver) {
        String dir_name = "screenshot";
        if (!(new File(dir_name).isDirectory())) {
            new File(dir_name).mkdir();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        try {
            File source_file = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));// 执行截屏
            FileUtils.copyFile(source_file, new File(dir_name + File.separator + time + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 截图命名为当前时间保存桌面
    public static void takeScreenshotByNow() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String time = sdf.format(new Date());
        String file = "C:\\Users\\Administrator\\Desktop\\bug截图\\" + time + ".png";
        FileUtils.copyFile(srcFile, new File(file));
    }

    // 截图重命名保存至桌面
    public static void takeScreenshotByName(String name) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String file = "C:\\Users\\Administrator\\Desktop\\bug截图\\" + name + ".png";
        FileUtils.copyFile(srcFile, new File(file));
    }



}
