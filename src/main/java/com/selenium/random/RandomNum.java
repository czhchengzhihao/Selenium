package com.selenium.random;

import com.selenium.log4j.LoggerController;

import java.util.Random;

public class RandomNum {
    final static LoggerController log = LoggerController.getLogger(RandomNum.class);

    //生成一个n为随机数
    public static long getNumRandom(int length) {
        //随机数乘以10^n次方
        long num = 0;
        num = (long) (Math.random() * Math.pow(10, length));
        log.info("生成的随机数为" + String.valueOf(num));
        return num;
    }

    //如输出一个范围之间的随机数
    public static long getNumRandom1(int min, int max) {

        long num = 0;
        Random random = new Random();
        num = random.nextInt(max - min + 1) + min;
        log.info(String.valueOf(num));
        return num;
    }

    //生成随机数字和字母
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(10) % 2 == 0 ? "char" : "num";
            if ("char".equals(charOrNum)) {
                int temp = random.nextInt(10) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equals(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        log.info(val);
        return val;
    }

}


