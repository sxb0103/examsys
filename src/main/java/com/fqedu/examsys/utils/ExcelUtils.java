package com.fqedu.examsys.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    /**
     * 读取上传的Excel内容
     *
     * @param fileName    上传的文件名
     * @param inputStream 输入流
     * @return 返回一个list集合，存储了从excel中读取的数据
     */
    public static List<Map<String, Object>> readExcel(String fileName, InputStream inputStream) throws IOException {

        //创建集合用来存储从excel中读取的内容
        List<Map<String, Object>> list = new ArrayList<>();

        //根据文件名判断，上传的excel文件时xls还是xlsx
        boolean ret = isXls(fileName);
        //创建一个空工作簿对象
        Workbook workbook = null;
        //根据excel类型生成响应的工作簿操作对象
        if (ret == true) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            workbook = new XSSFWorkbook(inputStream);
        }
        //获取excel中的sheet，注意excel的薄板从左到右下标从0开始一次递增，
        //获取excel中第一个sheet的数据（最左边的薄板）
        Sheet sheet = workbook.getSheetAt(0);
        //标题,获取sheet中第一行数据
        Row row = sheet.getRow(0);
        //获取row里最后一个单元格的编号
        short lastCellNum = row.getLastCellNum();
        //获取最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        //循环每一个行,i要从1开始，因为0行是标题行已经获取了
        for (int i = 1; i <= lastRowNum; i++) {
            //创建一个集合用来存储数据
            Map<String, Object> map = new HashMap<>();
            //获取当前循环行的数据对象
            Row row1 = sheet.getRow(i);
            //循环当前行的每一个单元格
            for (int j = 0; j < lastCellNum; j++) {
                //得到单元格的数据
                Cell cell = row1.getCell(j);
                //如果单元格数据为空，停止获取
                if (cell == null) {
                    continue;
                }
                //将获取到数据转为String格式
                cell.setCellType(CellType.STRING);
                //存储数据
                //第一个参数为j对应的标题行的值，
                //第二个参数为j对应的单元格的值
                map.put(row.getCell(j).getStringCellValue(), cell.getStringCellValue());
            }
            //添加当前行的数据到list集合
            list.add(map);
        }
        return list;
    }

    /**
     * 根据文件名判断，上传的excel文件时.xls文件还是.xlsx文件
     *
     * @param fileName 上传的文件名
     * @return 返回值为true表示上传文件为.xlsx，返回false表示上传文件为.xls
     */
    private static boolean isXls(String fileName) {

        //^.+\.(?i)(xls)$  正则表达式：(?i) 表示不区分大小写，思考如果用endsWith应该如何写
        if (fileName.matches("^.+\\.(?i)(xls)$")) {
            return true;
        } else {
            return false;
        }
    }
}





















































