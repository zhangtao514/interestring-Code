package com.daniu101;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    public static void main(String[] args) throws IOException {
        String fileName="D:\\所有员工1618560526152.xls";
        //一个输入流
        FileInputStream inputStream = new FileInputStream(fileName);
        //工作簿
        HSSFWorkbook sheet = new HSSFWorkbook(inputStream);
        //工作表里面有很多行
        HSSFSheet sheetAt = sheet.getSheetAt(0);
        //表中的一行
        for (Row row : sheetAt) {
           String id= row.getCell(0).getStringCellValue();
            String name= row.getCell(1).getStringCellValue();
            String work= row.getCell(2).getStringCellValue();
            String date= row.getCell(3).getStringCellValue();
            System.out.print(id+"  "+name+"  "+work+"  "+date);
            System.out.println();
        }
    }

}
