package com;

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
    String pass ="2212165";///密码不一样
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url, user, pass);

    public List getleads(String date){
//        String condition = "yyyymmdd='"+date+"' and volume >'300000' ORDER BY volume DESC";
//        return abstractDao.getMaps("stock","gpname,openprice,closeprice,volume",condition,"0","10");

        List<Map<String, Object>> maps = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select gpname,openprice,closeprice,volume from stock where yyyymmdd= '"+date+"' and volume > '300000' ORDER BY volume DESC");
            Integer i=0;
            while (rs.next()){
                if(i>9){break;}
                Map<String,Object> map = new HashMap<>();
                String gpName = rs.getString("gpname");
                Float open = rs.getFloat("openprice");
                Float close = rs.getFloat("closeprice");
                Float volume = rs.getFloat("volume");
                map.put("gpname",gpName);
                map.put("openprice",open);
                map.put("closeprice",close);
                map.put("volume",volume);
                maps.add(map);
                i++;
            }
            rs.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return maps;
    }

    public List getrise(String date){
//        String condition =  "yyyymmdd = '"+date+"' ORDER BY zhangfu DESC";
//        return abstractDao.getMaps("stock","gpname,highprice,zhangfu,lowprice",condition,"0","10");

        List<Map<String, Object>> maps = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select gpname,highprice,lowprice,zhangfu from stock where yyyymmdd="+date+" ORDER BY zhangfu DESC");
            Integer i=0;
            while (rs.next()){
                if(i>9){break;}
                Map<String,Object> map = new HashMap<>();
                String gpName = rs.getString("gpname");
                Float high = rs.getFloat("highprice");
                Float low = rs.getFloat("lowprice");
                Float zhangfu = rs.getFloat("zhangfu");
                map.put("gpname",gpName);
                map.put("highprice",high);
                map.put("lowprice",low);
                map.put("zhangfu",zhangfu);
                maps.add(map);
                i++;
            }
            rs.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return maps;
    }

    //修改后的gethigh
    public List<Map<String, Object>> gethigh(String date) {
        List<Map<String, Object>> maps = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select gpname,highprice,lowprice from stock where yyyymmdd="+date+" and ((highprice-lowprice)/lowprice) > 0.15 order by ((highprice-lowprice)/lowprice) desc");
            while (rs.next()){
                Map<String,Object> map = new HashMap<>();
                String gpName = rs.getString("gpname");
                Float high = rs.getFloat("highprice");
                Float low = rs.getFloat("lowprice");
                map.put("gpname",gpName);
                map.put("highprice",high);
                map.put("lowprice",low);
                maps.add(map);
            }
            rs.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return maps;
    }

    public List gethigh1(String date){
        //String date="20220615";
        String condition="yyyymmdd = '20220615' and (highprice-lowprice)/lowprice>0.15 ";
        return abstractDao.getMaps("stock","*",condition,"0","5");
    }

    //修改后的getsum版本
    public List<Map<String, Object>> getsum(String date) {
        Integer d = Integer.parseInt(date)-2;
        String date2 = Integer.toString(d);

        List<Map<String, Object>> maps = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select gpname from stock where yyyymmdd <='"+date+"' and yyyymmdd >='"+date2+"' group by gpname having sum(zhangfu)>20 and count(*)=3");
            List<String> gps=new ArrayList<>();
            while (rs.next()){
                String gpName = rs.getString("gpname");
                gps.add(gpName);
            }
            String gpss = "('"+String.join("','", gps)+"')";
            Statement statement1= connection.createStatement();
            ResultSet rs1 = statement1.executeQuery(
                    "select zhangfu,gpname,highprice,lowprice from stock where yyyymmdd <='"+date+"' and yyyymmdd >='"+date2+"' and gpname in "+gpss+" order by gpname");

            while(rs1.next()) {
                Map<String,Object> map = new HashMap<>();
                String gpName = rs1.getString("gpname");
                Float high = rs1.getFloat("highprice");
                Float low = rs1.getFloat("lowprice");
                Float zhangfu = rs1.getFloat("zhangfu");
                map.put("gpname", gpName);
                map.put("highprice", high);
                map.put("lowprice", low);
                map.put("zhangfu", zhangfu);
                maps.add(map);
            }
            rs.close();
            rs1.close();
            statement.close();
            statement1.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return maps;
    }

    public List getsum1() {
        String date="20190320";
        Integer d = Integer.parseInt(date)-2;
        String date2 = Integer.toString(d);

        String sql2 ="yyyymmdd <='"+date+"'and yyyymmdd >='"+date2+"' group by gpName having sum(convert(zhangfu,decimal(10,8)))>20 and count(*)=3";
        List<Map<String,Object>> tmp = abstractDao.getMaps("stock", "*", sql2);
        System.out.println(tmp);
        List<String> gpNames = new ArrayList<>();
        for (Map<String, Object> map : tmp) {
            gpNames.add((String) map.get("stock_gpName"));
        }
        List<Map<String,Object>> result =new ArrayList<>();
        for(String t:gpNames){
            // String sqlt = "yyyymmdd ='"+date+"' and gpName = '"+t+"'";
            String sqlt = "yyyymmdd <='"+date+"'and yyyymmdd >='"+date2+"'and gpName = '"+t+"'";
            List<Map<String, Object>> data = abstractDao.getMaps("stock", "*", sqlt);
            System.out.println(data);
            result.addAll(data);
        }
        return result;
    }


}

