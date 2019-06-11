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

        try {
            Class.forName("** DB Driver **");
            Connection con = DriverManager.getConnection("** SQLConection **");

            PreparedStatement ps = con.prepareStatement("** SQ Language **");

            ps.setString(1, username);
            ps.setString(2, password);

            int i = ps.executeUpdate();
            if (i > 0) {
                out.print("You are successfully registered...");
                resp.sendRedirect("login");
            }
                

        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();
    }
}
