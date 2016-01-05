package com.voyager.servlet;

import java.io.IOException;

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
					"user || pwd is not qualified"); // ����400 �ͻ��˾䷨���Ϸ�
			return;
		}
		UserDao userPwdDao = new UserAdd();
		boolean isSucceed = userPwdDao.Opt(new UserBean(user, pwd));
		userPwdDao.dispose();
		if (isSucceed) {
			response.addHeader("result", "1");
		}

	}

}
