package com.tenco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Totoservlet
 */
public class Totoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public Totoservlet() {
		super();
	}

	// get 요청시 동작
	// 주소 설계 - http://localhost:8080/d4/todo
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get 요청 확인");
		
		Todo todo = new Todo();
		todo.setId(100);
		todo.setTitle("오늘은 json 반환하기 훈련");
		todo.setComplted(false);

//		response.setContentType("application/json");
//		String strJson = "{\r\n" + "  \"userId\": 1,\r\n" + "  \"id\": 1,\r\n"
//				+ "  \"title\": \"delectus aut autem\",\r\n" + "  \"completed\": false\r\n" + "}";
		PrintWriter pw = response.getWriter();
		pw.write(todo.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
