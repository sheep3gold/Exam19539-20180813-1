package com.hand.service;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entity.Film;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 19:23 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public class editFilmDBService {
    private CustomerDao userDao = new CustomerDaoImpl();
    public boolean editFilm(Film film,int id) throws Exception{
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/sakila?"
                + "user=root&password=admin&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);

            boolean bool=userDao.editFilmDB(conn,id,film);
            return bool;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return false;

    }
}
