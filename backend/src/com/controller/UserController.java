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

    public ResultTo login(String username, String password){
        Map user =  abstractDao.getMap("user","*","username=\""+username+"\" and password=\""+password+"\"");
        ResultTo resultTo = new ResultTo();

        if(user==null) {
            user = abstractDao.getMap("user","*","email=\""+username+"\" and password=\""+password+"\"");
            resultTo.value = user;
            if(user == null){
                resultTo.msg = "登陆失败";
            }else {
                resultTo.msg = "登陆成功";
            }
        }
        else{
            resultTo.value = user;
            resultTo.msg = "登陆成功";
        }
        return resultTo;
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

    public boolean removeUser(String username) {
        return abstractDao.delete("user","username='"+username+"'");
    }
    public int changeUserInfo(String username, String newname, String newemail, String password) {
        if(abstractDao.delete("user","username='"+username+"'")){
            Map<String,Object> map = new HashMap<>();
            map.put("username",newname);
            map.put("password",password);
            map.put("email",newemail);

            Map user =  abstractDao.getMap("user","*","email='"+newemail+"'");
            if(user!=null){
                return -2;//该邮箱已被注册
            }
            user = abstractDao.getMap("user","*","username='"+newname+"'");
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
        else {
            return -3;
        }
    }
}
