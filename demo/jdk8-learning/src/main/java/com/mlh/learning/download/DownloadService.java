package com.mlh.learning.download;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mlh.learning.json.JsonUtil;
import com.mlh.learning.util.HttpUtil;
import com.mlh.learning.util.StringUtil;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning.download
 * @Description:
 * @date Date : 2019年05月08日 8:06 PM
 **/
public class DownloadService {

    public void downloadFile(){
        String url = "https://s.xinrenxinshi.com/recruitment/ajax-get-resume-data-by-id";
        String param = "?resumeId=fdecef7a03004acf81005be0c50cf0fb";
        url = url+param;
        Map<String, String> header = new HashMap<>();
        header.put("Cookie","zg_did=%7B%22did%22%3A%20%2216a349bbbf992-0cdbea5d103f0d-366e7e04-13c680-16a349bbbfb6b%22%7D; Hm_lvt_c596fa6dab972555146e7d904b1faea7=1555401174,1555410211,1555783435,1556447249; Hm_lvt_5c7fa123c5a1ec6351ee52cf02af17d1=1555660400,1555686683,1556163666,1557302531; hasExpPopShow=true; JSESSIONID=11uhp94tvlgts1t9l8uqr87km2; zg_352739e74baa40acb247e2f746542d02=%7B%22sid%22%3A%201557316308234%2C%22updated%22%3A%201557318838489%2C%22info%22%3A%201557111231376%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22s.xinrenxinshi.com%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22cuid%22%3A%20%22C870017E28000001AFAB3EF64CC81FCA%22%7D; Hm_lpvt_5c7fa123c5a1ec6351ee52cf02af17d1=1557318839; WAVESSID=797c19a5a380eb951fb03b0a64d278a837c7f0ba03322c26423562aecbeebe76375b5b4f13b4759b86863db0ff7c5ca6fd5462e2d36799ecd457f7; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2247364bf7a83711e68bf300163e001b1f%22%2C%22%24device_id%22%3A%2216a349bbc4819c-0bfa231a302291-366e7e04-1296000-16a349bbc4943a%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22first_id%22%3A%2216a349bbc4819c-0bfa231a302291-366e7e04-1296000-16a349bbc4943a%22%7D; lastAPITime=1557318855454");
        header.put("Accept-Encoding","gzip, deflate, br");
        header.put("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7");
        header.put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
        header.put("Accept","*/*");
        header.put("Connection","keep-alive");
        header.put("Cache-Control","no-cache");
        String result = HttpUtil.sendGet(url,header);
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONObject(";").getJSONArray("basic");
        String resumeDownloadUrl = jsonArray.getJSONObject(0).getString("resume");
        System.out.println(resumeDownloadUrl);
    }

    public static void main(String[] args) {
        DownloadService downloadService = new DownloadService();
        downloadService.downloadFile();
    }
}
