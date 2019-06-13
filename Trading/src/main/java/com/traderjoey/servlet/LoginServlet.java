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
 * �����������û�,���������ݿ����Ӻ�,��ȡ�������û������:
 * 1.admin/traderjoey123-
 * 2.root/traderjoey123-
 * 
 * ��ʱ�������������:
 * 1.��index.jsp���������û������벻ƥ������û�,��ص�index.jsp
 * 2.���û�������ƥ������û�,��ͻ�����ת��fan������k��ͼ:query.jsp
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











