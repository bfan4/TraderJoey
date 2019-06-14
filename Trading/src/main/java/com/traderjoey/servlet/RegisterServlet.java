package com.traderjoey.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traderjoey.entity.User;
import com.traderjoey.dao.impl.UserDAOImpl;

public class RegisterServlet extends HttpServlet {
    @Override
    /**
     * ���ú�̨��UserDAO����,ע���: 1.ע��ɹ�֮��Ҫ������ʾ�û�,����ת��login.jsp
     * 2.ע��ʧ��֮��ҲҪ������ʾ�û�,��Ȼ��ת��register.jsp 
     * FIXME fan ready for debug
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("HERE");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        
        try {
            user.setName(username);
            user.setPassword(password);
            user.setBalance(0.0f);
            boolean i = userDAOImpl.add(user);
            System.out.println(username);
            System.out.println(password);
            if (i == true) {
                
                System.out.println("Registe success");
                resp.sendRedirect("login.jsp");
            }else {
            
            System.out.println("Registe failed");
            resp.sendRedirect("register.jsp");
            }
            
        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();
    }
}
