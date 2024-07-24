package com.controller;

import dao.AbstractDaoImpl;
import org.MultipartFile;

import java.io.File;
import java.sql.*;
import java.util.*;

//7.15
public class datatest {
        //string driverClassName, String url, String userName, String passwordString driver :"com.mysql.cj.jdbc.Driver";
        String driver="com.mysql.cj.jdbc.Driver";
        String url ="jdbc:mysql://localhost:3306/test";
        String user ="root";
        String pass ="04297620";///密码不一样
        AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url, user, pass);

        public List getleads(){
                String date="20220615";
                String condition = "yyyymmdd='20220615' and volume >'300000' ORDER BY volume DESC";
                //res.sort(Comparator.comparing(map -> (Comparable) map.get("zhangfu"), Comparator.reverseOrder()));
                return abstractDao.getMaps("table_stock","*",condition,"0","10");

        }

        public List getrise(String date){
                //String date="20220615";
                String condition =  "yyyymmdd = '20220615' ORDER BY zhangfu DESC";
                //res.sort(Comparator.comparing(map -> (Comparable) map.get("zhangfu"), Comparator.reverseOrder()));
                return abstractDao.getMaps("table_stock","*",condition,"0","10");

        }

        public List gethigh(String date){
                //String date="20220615";
                String condition="yyyymmdd = '20220615' and (hiPrice-lowPrice)/lowPrice>0.15 ";
                //res.sort(Comparator.comparing(map -> (Comparable) map.get("zhangfu"), Comparator.reverseOrder()));
                return abstractDao.getMaps("table_stock","*",condition,"0","5");
        }

        public List getsum() {
                String date="20190320";
                String date3=Integer.toString(Integer.parseInt(date)-1);
                String date4=Integer.toString(Integer.parseInt(date)-2);
                        Integer d = Integer.parseInt(date)-2;
                        String date2 = Integer.toString(d);

                        String sql2 ="yyyymmdd <='"+date+"'and yyyymmdd >='"+date2+"' group by gpName having sum(convert(zhangfu,decimal(10,8)))>20 and count(*)=3";
                        List<Map<String,Object>> tmp = abstractDao.getMaps("table_stock", "*", sql2);
                        System.out.println(tmp);
                        List<String> gpNames = new ArrayList<>();
                        for (Map<String, Object> map : tmp) {
                                gpNames.add((String) map.get("table_stock_gpName"));
                        }
                        List<Map<String,Object>> result =new ArrayList<>();
                        for(String t:gpNames){
                               // String sqlt = "yyyymmdd ='"+date+"' and gpName = '"+t+"'";
                                String sqlt = "yyyymmdd <='"+date+"'and yyyymmdd >='"+date2+"'and gpName = '"+t+"'";
                                List<Map<String, Object>> data = abstractDao.getMaps("table_stock", "*", sqlt);
                                System.out.println(data);
                                result.addAll(data);
                        }
                        return result;
                }


}

