package com.mlh.learning;

import com.google.common.base.Splitter;
import com.mlh.learning.util.ExcelUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning
 * @Description:
 * @date Date : 2019年04月20日 7:04 PM
 **/
public class FileReaderTest {
    public static void main(String[] args) throws Exception{
        String fileName = "进行中总计";
        String ford = "/Users/malinghan/Desktop/统计";
        String filePath = "/Users/malinghan/Desktop/统计/进行中总计";
        readFile(filePath,ford,fileName);
    }

    /**
     * 读入TXT文件
     */
    public static void readFile( String pathname,String ford,String fileName) throws Exception{
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        FileReader reader = new FileReader(pathname);
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

        Map<String, Map<Integer,String>> outMap = new HashMap<>();
            String line;
            //网友推荐更加简洁的写法
//        out.write("公司名|201904|201903|201902|201901|201812\r\n");
        int c = 1;
            while ((line = br.readLine()) != null) {
                c++;
                System.out.println(c);
                // 一次读入一行数据
                List<String> res = Splitter.on("|").splitToList(line);
                String companyName = res.get(0).trim();
                String s201904 = res.get(1).trim();
                String s201903 = res.get(2).trim();
                String s201902 = res.get(3).trim();
                String s201901 = res.get(4).trim();
                if(!outMap.containsKey(companyName)) {
                    Map<Integer, String> o = new HashMap<>();
                    o.put(201904,s201904);
                    o.put(201903,s201903);
                    o.put(201902,s201902);
                    o.put(201901,s201901);
                    outMap.put(companyName,o);
                }else {
                    outMap.get(companyName).put(201904,s201904);
                    outMap.get(companyName).put(201903,s201903);
                    outMap.get(companyName).put(201902,s201902);
                    outMap.get(companyName).put(201901,s201901);
                }
            }
        List<List<String>> datas = new ArrayList<>();
        outMap.forEach((k,v) -> {
            List<String> data = new ArrayList<>();
            data.add(k);
            if(v.containsKey(201904)){
                data.add(v.get(201904));
            }else{
                data.add("");
            }
            if(v.containsKey(201903)){
                data.add(v.get(201903));
            }else{
                data.add("");
            }
            if(v.containsKey(201902)){
                data.add(v.get(201902));
            }else{
                data.add("");
            }
            if(v.containsKey(201901)){
                data.add(v.get(201901));
            }else{
                data.add("");
            }
            datas.add(data);
        });
//        out.flush(); // 把缓存区内容压入文件
        List<String> header = new ArrayList<>();
        header.add("公司名");
        header.add("201904");
        header.add("201903");
        header.add("201902");
        header.add("201901");
        try {
            boolean excel = ExcelUtils.writeExcel(datas, header, ford, fileName);
            System.out.println(excel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
