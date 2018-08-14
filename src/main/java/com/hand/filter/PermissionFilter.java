package com.hand.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 7:53 2018/8/14
 * @ Description：${description}
 * @ Modified By：
 */
@WebFilter(filterName = "PermissionFilter")
public class PermissionFilter implements Filter {
    private List<String> list = new ArrayList<String>();
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String forword=null;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String flag = "";
        flag= (String) session.getServletContext().getAttribute("flag");
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        if (servletPath.equals("/01/login.jsp")||servletPath.equals("/01/index.jsp")||servletPath.equals("/")
                ||servletPath.equals("/checkCustomerServlet")||servletPath.equals("/01/error.jsp")) {
            chain.doFilter(req, resp);
        }
        else {
            if (flag.equals("success")) {
                chain.doFilter(req, resp);
            } else {
                forword="/01/error.jsp";
                request.getRequestDispatcher(forword).forward(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
