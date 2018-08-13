package com.hand.service;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entity.Film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 17:13 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public class addFilmService {
    private CustomerDao userDao = new CustomerDaoImpl();
    public boolean addFilm(Film film) throws Exception{
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/sakila?"
                + "user=root&password=admin&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);

            boolean bool=userDao.addFilmtoDB(conn,film);
            return bool;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return false;

    }

    }

