package com.selenium.excel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    public static Object[][] getExcelUtil(String path, int sheet, int row, int column) throws IOException {
        InputStream file = new FileInputStream(path);
        Workbook xssfWorkbook = new XSSFWorkbook(file);
        Sheet xssfSheet = xssfWorkbook.getSheetAt(sheet); //Sheet 为excel的表单
        List<String[]> rows = new ArrayList<String[]>();
        int lastRowNum = xssfSheet.getLastRowNum();
        System.out.println("一共" + lastRowNum + "行");
        int columnNum = xssfSheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("一共" + columnNum + "列");
        for (int i = row; i <= lastRowNum; i++) {
            String row_col[] = new String[columnNum];
            for (int j = column; j < columnNum; j++) {
                xssfSheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);//先把类型设置为string
                row_col[j] = xssfSheet.getRow(i).getCell(j).getStringCellValue();
            }
            rows.add(row_col);
        }
        file.close();
        Object[][] data = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }
        return data;
    }

}
