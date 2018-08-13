package com.hand.dao;

import com.hand.entity.Customer;
import com.hand.entity.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 10:52 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public interface CustomerDao {
    public ResultSet get( Connection conn,Customer user) throws SQLException, Exception;
    public Map<Integer,Film> getFilm(Connection conn) throws SQLException;
    public boolean addFilmtoDB(Connection conn,Film film)throws SQLException;
    public boolean editFilmDB(Connection conn,int id,Film f)throws SQLException;
    public boolean deleteFilm(Connection conn,int id)throws SQLException;
}
