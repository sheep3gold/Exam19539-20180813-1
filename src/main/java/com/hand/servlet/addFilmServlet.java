package com.hand.servlet;

import com.hand.entity.Film;
import com.hand.service.addFilmService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 17:12 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
@WebServlet(name = "addFilmServlet")
public class addFilmServlet extends HttpServlet {
    private addFilmService addFilmService=new addFilmService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forword=null;
        RequestDispatcher rDispatcher = null;
        boolean bool=false;
        String title=request.getParameter("title");
        String description=request.getParameter("description");
        String language=request.getParameter("language");
        Film newFilm=new Film();
        newFilm.setTitle(title);
        newFilm.setDescription(description);
        newFilm.setLanguage(language);

        try {
            bool=addFilmService.addFilm(newFilm);
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
