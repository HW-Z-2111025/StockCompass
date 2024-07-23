package com.controller;

import com.po.ResultTo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import dao.AbstractDaoImpl;
import org.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String pass = "admin";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);

    public int login(String username, String password){
        Map user =  abstractDao.getMap("user","*","username=\""+username+"\" and password=\""+password+"\"");
//        ResultTo resultTo = new ResultTo();
//
//        if(user==null) {
//            resultTo.value = null;
//            resultTo.msg = "登陆失败";
//        }
//        else{
//            resultTo.value = user;
//            resultTo.msg = "登陆成功";
//        }
//        return resultTo;

        if(user==null){
            user = abstractDao.getMap("user","*","email=\""+username+"\" and password=\""+password+"\"");
        }
        if(user!=null){
            return 1;//登陆成功
        }
        else{
            return 0;//登陆失败
        }
    }
    public int register(String username, String password, String email){

        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("email",email);

        Map user =  abstractDao.getMap("user","*","email='"+email+"'");
        if(user!=null){
            return -2;//该邮箱已被注册
        }
        user = abstractDao.getMap("user","*","username='"+username+"'");
        if(user!=null){
            return -1;//该用户名已被注册
        }
        if(abstractDao.insert("user",map)){
            return 1; //注册成功
        }
        else{
            return 0; //向数据库插入数据失败
        }

    }
}
