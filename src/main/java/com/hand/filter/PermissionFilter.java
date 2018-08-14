package com.hand.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 7:53 2018/8/14
 * @ Description：${description}
 * @ Modified By：
 */
@WebFilter(filterName = "PermissionFilter")
public class PermissionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        boolean flag = (boolean) session.getAttribute("flag");
        String servletPath = request.getServletPath();
        if (servletPath.equals("/login.jsp")||servletPath.equals("/index.jsp")||servletPath.equals("/login")) {
            chain.doFilter(req, resp);
        } else {
            if (flag) {
                chain.doFilter(req, resp);
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}