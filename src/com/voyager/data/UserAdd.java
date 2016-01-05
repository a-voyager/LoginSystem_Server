package com.voyager.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAdd extends UserDao {

	@Override
	public boolean Opt(UserBean user) {
		addNewUser(user.getUserName(), user.getUserPwd());
		return true;
	}

	/**
	 * 添加新用户
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	private boolean addNewUser(String name, String pwd) {
		PreparedStatement statement = null;
		try {
			statement = conn
					.prepareStatement("insert into users (name, pwd) values (?, ?)");
			statement.setString(1, name);
			statement.setString(2, pwd);
			statement.execute();
		} catch (SQLException e) {
			return false;
		} finally {
			closeStatement(statement);
		}
		return true;
	}

}
