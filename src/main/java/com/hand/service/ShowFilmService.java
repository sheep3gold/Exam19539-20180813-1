package com.hand.service;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entity.Film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 15:28 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public class ShowFilmService {
    private CustomerDao userDao = new CustomerDaoImpl();

    public Map<Integer, Film> getFilm() throws Exception{
        Connection conn = null;
        Map<Integer,Film>filmMap=new HashMap<>();
        String url = "jdbc:mysql://localhost:3306/sakila?"
                + "user=root&password=admin&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);

             filmMap=userDao.getFilm(conn);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return  filmMap;
    }
}
