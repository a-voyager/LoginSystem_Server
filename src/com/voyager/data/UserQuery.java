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
	 * ��ѯ�û��������Ƿ���ȷ
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
			System.out.println("��ʼ��ѯ��");
			while (set.next()) {
				String name = set.getString("name");
				String pwd = set.getString("pwd");
				if (name.equals(inputName) && pwd.equals(inputPwd)) {
					System.out.println("name = " + name + "; pwd = " + pwd);
					System.out.println("������ȷ��");
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
