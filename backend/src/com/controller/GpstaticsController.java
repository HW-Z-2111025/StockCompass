package com.controller;

import dao.AbstractDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GpstaticsController {
    AbstractDaoImpl abstractDao = new AbstractDaoImpl("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","admin");

    /**
     * @param startDate 开始查询的时间 20231231
     * @param endDate   结束查询的时间 20240713
     * @return 返回到页面的是数据
     */
    public List getGpstatics(String startDate, String endDate, Integer pageNow, String gp){
        final Integer pageSize = 100;
        Integer startPage = (pageNow-1)*pageSize;
        return abstractDao.getMaps("stock","*","yyyymmdd > "+startDate+" and yyyymmdd < "+endDate+" and gpname = \""+gp+"\"", startPage.toString(), pageSize.toString());
    }

    public Map test2(){
        Map<String, Object[]> map = new HashMap<>();
        map.put("data1", new String[]{"衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"});
        map.put("data2", new Integer[]{5, 20, 36, 10, 10, 20});
        return map;
    }
}
