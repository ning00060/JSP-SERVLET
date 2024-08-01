package com.tenco.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	
	private static DataSource datasource;
	
	static {
			System.out.println("datasource 경로");
			InitialContext ctx;
			try {
				ctx = new InitialContext();
				datasource=(DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
				
			} catch (NamingException e) {
				e.printStackTrace();
			}

	}
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
	
	
}
