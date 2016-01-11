package com.voyager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voyager.data.UserAdd;
import com.voyager.data.UserBean;
import com.voyager.data.UserDao;
import com.voyager.utils.Utils;

public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		System.out.println("user = " + user + "; pwd = " + pwd);
		if (!Utils.isUserNameQualifiedRule(user)
				|| !Utils.isUserPwdQualifiedRule(pwd)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"user || pwd is not qualified"); // 返回400 客户端句法不合法
			return;
		}
		UserDao userPwdDao = new UserAdd();
		boolean isSucceed = userPwdDao.Opt(new UserBean(user, pwd));
		userPwdDao.dispose();
		PrintWriter writer = response.getWriter();
		if (isSucceed) {
			response.addHeader("result", "1");
			writer.write("注册成功！<br>");
		}else {
			writer.write("抱歉，注册失败！<br>");
		}
		response.setHeader("refresh", "3;url=" + request.getContextPath()
				+ "/index.jsp");

	}

}
