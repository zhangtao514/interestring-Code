package com.daniu101;

import com.daniu101.model.Person;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExcelWrite {
    public static void main(String[] args) {
        //工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //工作表
        HSSFSheet sheet = workbook.createSheet("所有人的工作表");

        //行 头部 第0行
        HSSFRow rowHead = sheet.createRow(0);
        //列 行列：单元格，写到单元格
        rowHead.createCell(0).setCellValue("id");
        rowHead.createCell(1).setCellValue("姓名");
        rowHead.createCell(2).setCellValue("工作");
        rowHead.createCell(3).setCellValue("时间");

        //创建一个对象，并写入Excel
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setName("张三");
        person.setWork("Java工程师");
        person.setDate(new Date());
        HSSFRow row1 = sheet.createRow(1);
        //列 行列：单元格，写到单元格
        row1.createCell(0).setCellValue(person.getId());
        row1.createCell(1).setCellValue(person.getName());
        row1.createCell(2).setCellValue(person.getWork());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=format.format(person.getDate());
        row1.createCell(3).setCellValue(dateString);

        List<Person> lists= new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person p = new Person();
            p.setId(UUID.randomUUID().toString());

            double r = Math.random();
            int rr=(int)(r*100);

            p.setName("张三"+rr);
            p.setWork("Java工程师"+rr);
            p.setDate(new Date());

            lists.add(p);
        }

        for (int i = 0; i < lists.size(); i++) {
            Person p = lists.get(i);
            //写入Excel
            //第i+2，第一次 2行
            HSSFRow row = sheet.createRow(i+2);
            //列 行列：单元格，写到单元格
            row.createCell(0).setCellValue(p.getId());
            row.createCell(1).setCellValue(p.getName());
            row.createCell(2).setCellValue(p.getWork());

            SimpleDateFormat formatP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStringP=format.format(person.getDate());
            row.createCell(3).setCellValue(dateStringP);
            System.out.println("正在写入"+p.getName());
        }
        /*
        * 写入文件:绝对路径
        * or 相对路径转绝对路径
        * */
        String filePathName="D:\\所有员工"+System.currentTimeMillis()+".xls";
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(filePathName);
            workbook.write(file);
            workbook.close();
            System.out.println("完成");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败");
        }


    }
}
