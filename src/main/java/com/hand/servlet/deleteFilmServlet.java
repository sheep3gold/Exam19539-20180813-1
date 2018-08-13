package com.hand.servlet;

import com.hand.service.deleteFilmService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 1:26 2018/8/14
 * @ Description：${description}
 * @ Modified By：
 */
@WebServlet(name = "deleteFilmServlet")
public class deleteFilmServlet extends HttpServlet {
    private deleteFilmService deleteFilmService=new deleteFilmService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forword=null;
        RequestDispatcher rDispatcher = null;
        boolean bool=false;
        try {
             bool=deleteFilmService.deleteFilm(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(bool){
            forword="01/hello.jsp";
        }else{
            forword="01/error.jsp";
        }
        rDispatcher = request.getRequestDispatcher(forword);
        rDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
