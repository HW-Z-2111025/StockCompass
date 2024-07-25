package com;

import com.po.ResultTo;
import dao.AbstractDaoImpl;
import org.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockController {
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String pass = "2212165";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);
    /**
     * @param startDate 开始查询的时间位置  20231231
     * @param endDate   结束查询的时间位置  20240713
     * @return   返回到页面的是数据
     */
//    public List  getStocks(String startDate,String endDate,Integer pageNow,String gpName){
//        Integer PAGESIZE = 100;
//        Integer start = (pageNow-1)*PAGESIZE;
//        //return   abstractDao.getMaps("table_stock","*","yyyymmdd > "+startDate+" and yyyymmdd < "+endDate,start.toString(),PAGESIZE.toString());
//        return  abstractDao.getMaps("table_stock","*","yyyymmdd > "+startDate+" and yyyymmdd < "+endDate+" and gpName='"+gpName+"'",start.toString(),PAGESIZE.toString());
//        //return  abstractDao.getMaps("table_stock","yyyymmdd",null);
//
//    }
    public List<Map<String, Object>> getStocks(String startDate, String endDate, String pageNow, String gpName) {
        Integer PAGESIZE = 100;
        Integer start = (Integer.parseInt(pageNow) - 1) * PAGESIZE+1;
        String orderClause = " ORDER BY yyyymmdd ASC";
        String whereClause = "yyyymmdd > '" + startDate + "' AND yyyymmdd < '" + endDate + "' AND gpname='" + gpName + "'";
        String queryConditions = whereClause + orderClause;
        System.out.println("good");
        // 执行查询

        System.out.println(pageNow);
        if(pageNow.equals("1")){
            return abstractDao.getMaps("stock", "*", queryConditions, start.toString(), PAGESIZE.toString());
        }
        else{
            PAGESIZE = 130;
            Integer s=start-30;
            return abstractDao.getMaps("stock", "*", queryConditions, s.toString(), PAGESIZE.toString());
        }
    }

}

