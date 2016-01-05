package com.voyager.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class UserDao {

	/**
	 * ���ݿ����Ӷ���
	 */
	protected Connection conn;

	/**
	 * ���캯�� �������ݿ�
	 */
	public UserDao() {

		Properties properties = new Properties(); // ��ȡ�����ļ�
		try {
			properties.load(new FileInputStream(new File(UserDao.class
					.getClassLoader().getResource("config.properties")
					.getPath())));
			System.out.println(properties.getProperty("SQLDriver"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Class.forName(properties.getProperty("SQLDriver"));
		} catch (ClassNotFoundException e) {
			System.out.println("MySql load failed.");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(
					properties.getProperty("SQLAddr"),
					properties.getProperty("SQLUserName"),
					properties.getProperty("SQLUserPwd"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public abstract boolean Opt(UserBean user);
	
	
	protected void closeStatement(Statement statement) {
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				statement = null;
			}
	}

	/**
	 * �ͷ���Դ
	 */
	public void dispose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
