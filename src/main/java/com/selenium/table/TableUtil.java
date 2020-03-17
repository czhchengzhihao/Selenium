package com.selenium.table;

import com.selenium.find_elenment.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableUtil {
    public static void traverseTable(By by) {
        //获取table表格
        WebElement webElement = WebElementUtil.findElement(by);
        List<WebElement> rows = webElement.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.println("table表格错误");
        }
    }
 /*   WebElement table = WebElementUtils.findElement(By.id("dept-list"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
        List<WebElement> cols = row.findElements(By.tagName("td"));
        for (WebElement col : cols) {
            System.out.print(col.getText() + "\t");
        }
        System.out.println("");
    }*/
}
