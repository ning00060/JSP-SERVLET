package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/test1")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public testServlet() {
        super();
    }
    
    static {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		
		String URL="jdbc:mysql://localhost:3306/db_todo?serverTimezone=Asia/Seoul";
		String name="root";
		String password="asd123";
		
		String insertTodoSQL="INSERT INTO tb_todo(title,description) VALUES(?,?	)";
		
		try {
			Connection conn=DriverManager.getConnection(URL,name,password);
			PreparedStatement pstmt= conn.prepareStatement(insertTodoSQL);
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			int count=pstmt.executeUpdate();
			System.out.println(count);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
