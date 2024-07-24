package com;

import com.po.ResultTo;
import dao.AbstractDaoImpl;
import org.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zixun {
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String pass = "2212165";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);


    public List news(String date, Integer pagenow){
        Integer PAGESIZE = 100;
        Integer start = (pagenow-1)*PAGESIZE;
        return abstractDao.getMaps("news","*","date ="+date,start.toString(),PAGESIZE.toString());
    }

    public List discuss(String date, Integer pagenow){
        Integer PAGESIZE = 100;
        Integer start = (pagenow-1)*PAGESIZE;
        return abstractDao.getMaps("discuss","*","date="+date,start.toString(),PAGESIZE.toString());
    }

    public List<Map<String, Object>> stockorder(String date) {
        Integer TOP_SIZE = 10;
//        String sql = "yyyymmdd = '"+ date +"' ORDER BY zhangfu DESC";
        String sql = "yyyymmdd = '" + date + "' ORDER BY CONVERT(zhangfu, DECIMAL(10, 8)) DESC";
        return abstractDao.getMaps("stock", "*", sql, "1", "10");
    }

    public List<Map<String, Object>> longhu(String date) {
        //价格振幅=（当日最高价-当日最低价）/当日最低价*100％。
        String sql1 ="yyyymmdd='"+date+"' and (convert(highprice,DECIMAL(6, 3))-convert(lowprice,DECIMAL(6, 3)))/convert(lowprice,DECIMAL(6, 3)) > 0.10 order by (convert(highprice,DECIMAL(6, 3))-convert(lowprice,DECIMAL(6, 3)))/convert(lowprice,DECIMAL(6, 3)) desc";
        return abstractDao.getMaps("stock", "*", sql1, "1", "10");
    }

    public List<Map<String, Object>> longhu2(String date) {
        Integer d = Integer.parseInt(date)-2;
        String date2 = Integer.toString(d);

        String sql2 ="yyyymmdd <='"+date+"'and yyyymmdd >='"+date2+"' group by gpname having sum(convert(zhangfu,decimal(10,8)))>20 and count(*)=3";
        List<Map<String,Object>> tmp = abstractDao.getMaps("stock", "*", sql2);
//        System.out.println(tmp);
        List<String> gpNames = new ArrayList<>();
        for (Map<String, Object> map : tmp) {
            gpNames.add((String) map.get("stock_gpname"));
        }
//        String gps = String.join("','", gpNames);
//        System.out.println(gps);
//        String sql3 = "yyyymmdd ='"+date+"' and gpname in ('"+gps+"')";

        List<Map<String,Object>> result =new ArrayList<>();
        for(String t:gpNames){
            String sqlt = "yyyymmdd ='"+date+"' and gpname = '"+t+"'";
            List<Map<String, Object>> data = abstractDao.getMaps("stock", "*", sqlt);
            result.addAll(data);
        }
        return result;
    }
}
