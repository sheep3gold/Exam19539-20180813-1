package com.hand.service;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entity.Film;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 1:27 2018/8/14
 * @ Description：${description}
 * @ Modified By：
 */
public class deleteFilmService {
    private CustomerDao userDao = new CustomerDaoImpl();

    public boolean deleteFilm(int id) throws Exception{
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/sakila?"
                + "user=root&password=admin&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);

            boolean bool=userDao.deleteFilm(conn,id);
            return bool;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return false;

    }
}
