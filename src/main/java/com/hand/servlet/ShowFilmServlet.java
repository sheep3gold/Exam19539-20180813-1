package com.hand.servlet;

import com.hand.entity.Film;
import com.hand.service.ShowFilmService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 15:14 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
@WebServlet(name = "ShowFilmServlet")
public class ShowFilmServlet extends HttpServlet {
    private ShowFilmService showFilmService=new ShowFilmService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rDispatcher = null;
        String forword=null;
        try {
            Map<Integer,Film> filmMap=showFilmService.getFilm();
//            List list=showFilmService.getFilm();
            forword="/01/film.jsp";
            request.setAttribute("myfilm",filmMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rDispatcher = request.getRequestDispatcher(forword);
        rDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
