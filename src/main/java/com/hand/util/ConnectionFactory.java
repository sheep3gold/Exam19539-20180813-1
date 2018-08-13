package com.hand.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 10:58 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public class ConnectionFactory {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/sakila";
    private static String user="root";
    private static String password="admin";

    private static final ConnectionFactory factory = new ConnectionFactory();

    private Connection conn;

    static{
//        Properties prop = new Properties();
//        try {
//            InputStream in =ConnectionFactory.class.getClassLoader()
//                    .getResourceAsStream("ManageConfig.properties");
//            prop.load(in);
//        } catch (Exception e) {
//            System.out.println("===========配置文件读取错误===========");
//        }
//        driver=prop.getProperty("driver");
//        url=prop.getProperty("url");
//        user=prop.getProperty("user");
//        password=prop.getProperty("password");
//        System.out.println(driver);

//        driver="com.mysql.jdbc.Driver";
//        url="jdbc:mysql://localhost:3306/sakila";
//        user="root";
//        password="admin";
    }
    private ConnectionFactory () {

    }
    public static ConnectionFactory getInstance() {
        return factory;
    }
    public Connection makeConnection() {
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            System.out.println(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
