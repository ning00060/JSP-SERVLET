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

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("초기화 하기");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do get 메서드 작동");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		System.out.println("name:"+name+"email:"+email+"age:"+age);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/demo6?serverTimezone=Asia/Seoul";
			Connection conn = DriverManager.getConnection(url, "root", "asd123");
			PreparedStatement pstmt;

				if (email == null || email.trim().isEmpty()) {
					System.out.println("email null 작동");
					String sql = "select * from users where name=? and age=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, age);
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
					System.out.println("입력됨");
					request.setAttribute("userList", userList);


					request.getRequestDispatcher("resultTestSet.jsp").forward(request, response);
				}
				if (age == null||age.trim().isEmpty()) {
					String sql = "select * from users where name=? and email=?";
					pstmt = conn.prepareStatement(sql);
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
				}
				if (age != null && email != null) {
					
				}

			

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
