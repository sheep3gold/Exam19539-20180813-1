package com.hand.dao.impl;

import com.hand.dao.CustomerDao;
import com.hand.entity.Customer;
import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 10:53 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public class CustomerDaoImpl implements CustomerDao{
    @Override
    public ResultSet get( Connection conn,Customer user) throws Exception{
        ResultSet rs;
        Statement statement=conn.createStatement();
        rs=statement.executeQuery("select * from customer where first_name= \""+user.getName()+"\"");
        return rs;
    }

    @Override
    public Map<Integer,Film> getFilm(Connection conn) throws SQLException {

        String sql = "SELECT film_id,title,description,l.`name`\n" +
                "from film f,`language` l\n" +
                "WHERE f.language_id=l.language_id";
        ResultSet rs;
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sql);

        Map<Integer,Film> filmMap=new HashMap<>() ;

        while (rs.next()){
            Film film=new Film();
            film.setFilm_id(rs.getInt(1));
            film.setTitle(rs.getString(2));
            film.setDescription(rs.getString(3));
            film.setLanguage(rs.getString(4));
            filmMap.put(rs.getRow(),film);
        }
        return filmMap;
//        List list = new ArrayList();
//        ResultSetMetaData md = rs.getMetaData();
//        int columnCount = md.getColumnCount();
//        while (rs.next()) {
//            Map<String, Object> rowData = new HashMap<>();
//            for (int i = 1; i <= columnCount; i++) {
//                rowData.put(md.getColumnName(i), rs.getObject(i));
//            }
//            list.add(rowData);
//
//        }
//        return list;
    }
    @Override
    public boolean addFilmtoDB(Connection conn, Film film) throws SQLException {
        String title=film.getTitle();
        String description=film.getDescription();
        String language=film.getLanguage();

        String sql="INSERT INTO film(title,description,language_id)\n" +
                "VALUES(\""+title+"\",\""+description+"\",(SELECT language_id  from `language` l\n" +
                "WHERE l.NAME =\""+language+"\"))";

        Statement statement=conn.createStatement();
        int rtn=statement.executeUpdate(sql);
        if(rtn>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean editFilmDB(Connection conn, int id,Film film) throws SQLException {
        String sql="UPDATE film\n" +
                "set title=\""+film.getTitle()+"\",description=\""+film.getDescription()+
                "\",language_id=(SELECT language_id from `language` where name=\""+film.getLanguage()+"\")\n" +
                "WHERE film_id="+id+";";
        Statement statement=conn.createStatement();
        int rtn=statement.executeUpdate(sql);
        if(rtn>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean deleteFilm(Connection conn, int id) throws SQLException {
        String sql="delete from film where first_id="+id+";";
        Statement statement=conn.createStatement();
        int rtn=statement.executeUpdate(sql);
        if(rtn>0){
            return true;
        }else {
            return false;
        }

    }


}
