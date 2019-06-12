package com.traderjoey.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 退出当前登录,使当前用户为空
 * FIXME fan ready for debug
 * @author Bruce
 *
 */
public class LogoutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("You are successfully logged out! Thank you");
        HttpSession session = req.getSession(false);
        // session.setAttribute("user", null);
        session.removeAttribute("user");
        session.getMaxInactiveInterval();
    }
    
}
