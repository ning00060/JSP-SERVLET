package com.tenco.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	private static DataSource datasource;
	
	// 정적 초기화 블록
	
	static {
		// TODO - 삭제예정
		System.out.println("111111111");
		
			try {
				// InitialContext 객체를 생성하여 JNDI API 기술을 통해 존재하는 리소스찾는 기법
				InitialContext ctx= new InitialContext();
				datasource=(DataSource)ctx.lookup("java:comp/env/jdbc/MyDB");
				
			} catch (NamingException e) {
				e.printStackTrace();
			}
	}
			
			public static Connection getConnection() throws SQLException {
				return datasource.getConnection();
			}
	

}