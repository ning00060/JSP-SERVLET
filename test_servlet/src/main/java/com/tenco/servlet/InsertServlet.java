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

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("insert초기화 시작");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/demo6?serverTimezone=Asia/Seoul";
			Connection conn = DriverManager.getConnection(url, "root", "asd123");
			PreparedStatement pstmt = conn.prepareStatement("insert into users(name,email,age) values(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, age);
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			response.sendRedirect("result.jsp?message=good");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=bad");
		}

	}

}
