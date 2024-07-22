package com.controller;

import dao.AbstractDaoImpl;

import java.util.List;

public class EmpController {
    /**
     * 构造函数的参数：String driverClassName, String url, String userName, String password
     */
    AbstractDaoImpl abstractDao = new AbstractDaoImpl("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","admin");

    public List getEmps(){
        return abstractDao.getMaps("emp","*",null);
    }
}
