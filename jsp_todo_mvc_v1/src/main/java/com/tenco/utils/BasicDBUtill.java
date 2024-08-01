package com.tenco.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicDBUtill {

	private static final String URL = "jdbc:mysql://localhost:3306/m_todo?servertTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "asd123";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
}
