package com.voyager.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserQuery extends UserDao {

	@Override
	public boolean Opt(UserBean user) {
		return isUserQualifiedQuery(user.getUserName(), user.getUserPwd());
	}

	/**
	 * 查询用户名密码是否正确
	 * 
	 * @param inputName
	 * @param inputPwd
	 * @return
	 */
	private boolean isUserQualifiedQuery(String inputName, String inputPwd) {
		boolean flag = false;
		Statement statement = null;
		try {
			statement = conn.createStatement();
			ResultSet set = statement
					.executeQuery("select name,pwd from users");
			System.out.println("开始查询！");
			while (set.next()) {
				String name = set.getString("name");
				String pwd = set.getString("pwd");
				if (name.equals(inputName) && pwd.equals(inputPwd)) {
					System.out.println("name = " + name + "; pwd = " + pwd);
					System.out.println("密码正确！");
					flag = true;
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
		}

		return flag;
	}

}
