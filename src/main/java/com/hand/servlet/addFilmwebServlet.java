package com.hand.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 17:06 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
@WebServlet(name = "addFilmwebServlet")
public class addFilmwebServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rDispatcher = null;
        String forword=null;
        forword="01/addFilm.jsp";
        rDispatcher = request.getRequestDispatcher(forword);
        rDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
