package com.tenco.util;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicDBUtil {
	
	
	private static final String URL="jdbc:mysql://localhost:3306/db_todo2?serverTimezone=Asia/Seoul";
	private static final String USER="root";
	private static final String PASSWORD="asd123";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL,USER,PASSWORD);
	}
}
