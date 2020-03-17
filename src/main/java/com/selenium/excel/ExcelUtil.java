package com.selenium.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {
    //新方法（使用中）---------------------------------------------------------------------------------------------
    public List<String[]> rosolveFile(InputStream is, String suffix,
                                      int startRow) throws IOException, FileNotFoundException {
        Workbook xssfWorkbook = null;
        if ("xls".equals(suffix)) {
            xssfWorkbook = new HSSFWorkbook(is);//HSSFWorkbook为Excel的文档对象
        } else if ("xlsx".equals(suffix)) {
            xssfWorkbook = new XSSFWorkbook(is);
        }
        Sheet xssfSheet = xssfWorkbook.getSheetAt(0); //Sheet 为excel的表单
        if (xssfSheet == null) {
            return null;
        }
        ArrayList<String[]> list = new ArrayList<String[]>();
        int lastRowNum = xssfSheet.getLastRowNum();
        for (int rowNum = startRow; rowNum <= lastRowNum; rowNum++) {
            if (xssfSheet.getRow(rowNum) != null) {
                Row xssfRow = xssfSheet.getRow(rowNum);// Row excel的行
                short firstCellNum = xssfRow.getFirstCellNum();
                short lastCellNum = xssfRow.getLastCellNum();
                if (firstCellNum != lastCellNum) {
                    String[] values = new String[lastCellNum];
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        Cell xssfCell = xssfRow.getCell(cellNum);//Cell excel的格子单元
                        if (xssfCell == null) {
                            values[cellNum] = "";
                        } else {
                            values[cellNum] = parseExcel(xssfCell);
                        }
                    }
                    list.add(values);
                }
            }
        }
        return list;
    }

    //判断每一个单元格里的内容类型
    public String parseExcel(Cell cell) {
        String result = null;

        switch (cell.getCellType()) {

            case HSSFCell.CELL_TYPE_NUMERIC:// 判断单元格的值是否为数字类型

                if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                            .getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 58) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
					/*yyyy年m月d日----->31
					yyyy-MM-dd-----	14
					yyyy年m月-------	57
					m月d日  ----------58
					HH:mm-----------20
					h时mm分  -------	32*/

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double value = cell.getNumericCellValue();
                    Date date = DateUtil
                            .getJavaDate(value);
                    result = sdf.format(date);
                } else {
                    double value = cell.getNumericCellValue();
                    CellStyle style = cell.getCellStyle();
                    DecimalFormat format = new DecimalFormat();
                    String temp = style.getDataFormatString();
                    // 单元格设置成常规
                    if (temp.equals("General")) {
                        format.applyPattern("#");
                    }
                    result = format.format(value);
                }
                break;
            case HSSFCell.CELL_TYPE_STRING:// 判断单元格的值是否为String类型
                result = cell.getRichStringCellValue().toString();
                break;
            case HSSFCell.CELL_TYPE_BLANK://判断单元格的值是否为布尔类型
                result = "";
            default:
                result = "";
                break;
        }
        return result;
    }
  /*
  哔哩哔哩
  Excel parse = new Excel();
    InputStream inputStream = new FileInputStream("D:\\员工管理.xlsx");
    String suffix = "xlsx";
    //从第几行开始读
    int startRow = 1;
    //集合中的每一个元素对应一行解析过得数据
    List<String[]> result = parse.rosolveFile(inputStream, suffix, startRow);
        for (int i = 0; i < result.size(); i++) {
        String[] ss = result.get(i);
        String p_name = ss[0];
        String p_sex = ss[1];
        }


        for (String[] ss : result) {
         String p_name = ss[0];
            String p_sex = ss[1];}*/
}
