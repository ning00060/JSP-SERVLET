package come.tenco.servlet;

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

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("InsertServlet 초기화");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// http://localhost:8080/InsertServlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/demo5?serverTimezone=Asia/Seoul";
			Connection conn = DriverManager.getConnection(dbUrl, "root", "asd123");
			String sql = "INSERT INTO users(name,email) values(?,?)";

			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			response.sendRedirect("result.jsp?message=success");
		} catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=error");
		}
	}

}
