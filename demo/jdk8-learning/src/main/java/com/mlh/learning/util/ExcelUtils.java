package com.mlh.learning.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * @author : linghan.ma
 * @Package com.mlh.learning.util
 * @Description:
 * @date Date : 2019年04月20日 8:08 PM
 **/

/**
 * excel生成工具类
 *
 * @author tp
 *
 */
public class ExcelUtils {

    /**
     * 生成excel
     *
     * @param datas
     *            数据
     * @param header
     *            表头
     * @param folder
     *            文件路径
     * @param fileName
     *            文件名称
     * @return
     */
    public static boolean writeExcel(List<List<String>> datas, List<String> header, String folder, String fileName) {

        if (datas == null || datas.isEmpty() || header == null || header.isEmpty() || StringUtil.isEmpty(folder)
                || StringUtil.isEmpty(fileName)) {
            return false;
        }
        // 判断路径是否正确
        File file = new File(folder);
        if (!file.isDirectory()) {
            return false;
        }
        // 设置文件后缀
        if (!fileName.endsWith(".xls")) {
            fileName = fileName + ".xls";
        }

        // 第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 第二部，在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet("统计表");
        // 第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，设置表头
        for (int i = 0; i < header.size(); i++) {
            row.createCell(i).setCellValue(header.get(i));
        }

        // 第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
        for (int i = 0; i < datas.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            List<String> data = datas.get(i);
            // 创建单元格设值
            for (int j = 0; j < data.size(); j++) {
                row1.createCell(j).setCellValue(data.get(j));
            }
        }

        // 将文件保存到指定的位置
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(folder + "/" + fileName);
            workbook.write(fos);
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

