package com.traderjoey.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traderjoey.bean.User;
import com.traderjoey.dao.impl.UserDAOImpl;

public class RegisterServlet extends HttpServlet {
    @Override
    /**
     * ���ú�̨��UserDAO����,ע���: 1.ע��ɹ�֮��Ҫ������ʾ�û�,����ת��login.jsp
     * 2.ע��ʧ��֮��ҲҪ������ʾ�û�,��Ȼ��ת��register.jsp 
     * FIXME fan already done
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        
        try {
            user.setName(username);
            user.setPassword(password);
            boolean i = userDAOImpl.add(user);
            
            if (i == true) {
                out.print("You are successfully registered...");
                resp.sendRedirect("login");
            }
            out.print("Registered failed...");
            resp.sendRedirect("register");
            
        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();
    }
}
