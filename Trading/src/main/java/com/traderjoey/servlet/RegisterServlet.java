package com.traderjoey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	@Override
	/**
	 * 调用后台的UserDAO来做,注意点:
	 * 1.注册成功之后要弹框提示用户,并跳转回login.jsp
	 * 2.注册失败之后也要弹框提示用户,仍然跳转回register.jsp
	 * FIXME fan
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	//
}
