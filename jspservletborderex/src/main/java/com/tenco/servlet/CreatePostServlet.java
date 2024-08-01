package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/create-post")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreatePostServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 기본값 설정(언어설정)
		request.setCharacterEncoding("UTF-8");
		
		// HTTP 요청 메시ㅣ지에서 데이터추출
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		// 인증 검사 생략(로그인 여부 확인)
		// 데이터 유횽검사는 생략
		
		try(Connection conn = DBUtil.getConnection()) {
			String sql= " INSERT INTO posts(title,content) values(?,?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.executeUpdate();
			
			response.sendRedirect("result.jsp?message=create-success");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=error");
		}
	}

}
