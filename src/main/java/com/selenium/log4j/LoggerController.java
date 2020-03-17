package com.selenium.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lenovo on 2016/11/9.
 */
public class LoggerController {
    private static Logger logger = null;
    private static LoggerController logg = null;

    public static LoggerController getLogger(Class<?> T) {
        if (logger == null) {
            Properties props = new Properties();   //实例化一个Properties类，处理log4j.Properties文件

            try {
                String proPath = System.getProperty("user.dir") + File.separator + "log4j_config" + File.separator + "log4j.properties";
                InputStream is = new FileInputStream(proPath);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PropertyConfigurator.configure(props);
            logger = Logger.getLogger(T);
            logg = new LoggerController();

        }
        return logg;
    }
    //重写logger方法

    public void info(String msg) {
        logger.info(msg);
    }

    public void debug(String msg) {
        logger.debug(msg);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }

    public void error(String msg) {
        logger.error(msg);
    }

}