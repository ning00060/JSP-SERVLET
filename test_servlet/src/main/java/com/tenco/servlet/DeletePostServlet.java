package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Struct;

@WebServlet("/post/delete-post")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePostServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("boardId");
		String sql="DELETE FROM posts WHERE id=?";
		try (Connection conn=DBUtil.getConnection()){
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(id));
			pstmt.executeUpdate();
			response.sendRedirect("result.jsp?message=delete-success");
		} catch (Exception e) {
			response.sendRedirect("result.jsp?message=error");
			e.printStackTrace();
			}
	}

}
