package com.traderjoey.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traderjoey.entity.User;
import com.traderjoey.dao.impl.UserDAOImpl;

/**
 * 定两个测试用户,后续和数据库连接后,再取真正的用户来检查:
 * 1.admin/traderjoey123-
 * 2.root/traderjoey123-
 * 
 * 暂时先完成两个功能:
 * 1.若index.jsp传过来的用户名密码不匹配测试用户,则回到index.jsp
 * 2.若用户名密码匹配测试用户,则客户端跳转到fan已做的k线图:query.jsp
 * 
 * @author Bruce
 * FIXME fan ready for debug
 */
@WebServlet(name = "UserLoginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new UserDAOImpl().verify(name, password);
        if(null != user) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("showDashboard");
        }else {
            resp.sendRedirect("index.jsp");
        }
        
    }
}











