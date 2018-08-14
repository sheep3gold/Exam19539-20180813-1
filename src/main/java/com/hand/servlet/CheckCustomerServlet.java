package com.hand.servlet;

import com.hand.entity.Customer;
import com.hand.service.CheckCustomerService;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Currency;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 12:10 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public class CheckCustomerServlet  extends HttpServlet {
    private CheckCustomerService checkCustomerService=new CheckCustomerService();

    public CheckCustomerServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cname = request.getParameter("uname");

        RequestDispatcher rDispatcher = null;
        String forword = null;
        boolean flag;

        if (cname == null ) {
            request.setAttribute("msg", "用户名为空！");
            rDispatcher = request.getRequestDispatcher("/02/error.jsp");
            rDispatcher.forward(request, response);

        } else {
            Customer customer=new Customer();
            customer.setName(cname);
            boolean bool= false;
            try {
                bool = checkCustomerService.check(customer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bool){
                forword="/01/hello.jsp";
                request.setAttribute("flag",true);

            }else {
                forword = "/01/error.jsp";
            }
            rDispatcher = request.getRequestDispatcher(forword);
            rDispatcher.forward(request, response);
        }
    }
}
