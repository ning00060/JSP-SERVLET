package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/select2")
public class SelectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectServlet2() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("초기화 하기");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/demo6?serverTimezone=Asia/Seoul";
			Connection conn = DriverManager.getConnection(url, "root", "asd123");
			PreparedStatement pstmt;
			
					String sql = "select * from users ";
					pstmt = conn.prepareCall(sql);
					ResultSet rs = pstmt.executeQuery();
					List<Map<String, String>> userList = new ArrayList<>();
					while (rs.next()) {
						Map<String, String> userMap = new HashMap<>();
						userMap.put("id", rs.getString("id"));
						userMap.put("name", rs.getString("name"));
						userMap.put("email", rs.getString("email"));
						userMap.put("age", rs.getString("age"));
						userList.add(userMap);
					}

					request.setAttribute("userList", userList);


					request.getRequestDispatcher("resultTestSet.jsp").forward(request, response);
				

			

		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	public void destroy() {
		System.out.println("destroy 작동");
	}

}
