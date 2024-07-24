package com.controller;

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
    String pass = "429616";
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

        // 添加 ORDER BY 子句来按 yyyymmdd 升序排列
        String orderClause = " ORDER BY yyyymmdd ASC";

        // 构建完整的 WHERE 子句
        String whereClause = "yyyymmdd > '" + startDate + "' AND yyyymmdd < '" + endDate + "' AND gpName='" + gpName + "'";

        // 拼接完整的查询条件字符串
        String queryConditions = whereClause + orderClause;

        // 执行查询
        return abstractDao.getMaps("table_stock", "*", queryConditions, start.toString(), PAGESIZE.toString());
    }


    public Boolean register(String username, String password, String phone, MultipartFile file){
        String path = this.getClass().getResource("/").getPath()+"web/";
        File  folder = new File(path);
        if(!folder.exists()){
            folder.mkdirs();
        }
        file.transferTo(new File(path+username+".jpg"));

        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("phone",phone);
        map.put("header",username+".jpg");
        return abstractDao.insert("user",map);
    }

    public ResultTo login(String username,String password){
        Map user =  abstractDao.getMap("user","*","username='"+username+"' and password='"+password+"'");
        ResultTo resultTo = new ResultTo();  //存数据
        if(user==null){
            resultTo.value=null;
            resultTo.msg = "登录失败";
        }else {
            resultTo.value =user;
            resultTo.msg = "登录成功";
        }
        return resultTo;
    }
}

