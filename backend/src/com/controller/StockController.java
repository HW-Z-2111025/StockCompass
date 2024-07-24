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
    String url = "jdbc:mysql://cent1:3306/test";
    String user = "root4";
    String pass = "123456";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);
    /**
     * @param startDate 开始查询的时间位置  20231231
     * @param endDate   结束查询的时间位置  20240713
     * @return   返回到页面的是数据
     */
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
}

