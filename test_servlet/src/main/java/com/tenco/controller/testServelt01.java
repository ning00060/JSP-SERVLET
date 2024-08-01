package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mysql.cj.Session;

@WebServlet("/test2")
public class testServelt01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public testServelt01() {
		super();
		System.out.println("인스턴스 생성단계");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("new 초기화");
	}

	// http://localhost:8080/ts1/test2?type="get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("요청처리 :get으로");

		response.setContentType("text/html; charset=UTF-8");
		String type1 = request.getParameter("type");
		String phrasing = "연습상황 요청방식:" + type1 + " 으로 받음";

		response.getWriter().print("<html><body> <h2>get으로받아보기" + phrasing + "성공 </h2></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type2 = request.getParameter("type");

		String username = request.getParameter("username");
		
//	String username=(String) request.getAttribute("username");
		// servlet 이나 jsp 에서 attribute를 사용 -> html은 parameter를 씀
		
		System.out.println(username + "첫이름");
		if (username != null && !username.trim().isEmpty()) {

//		request.setAttribute("username", username); -> 사용안함

			System.out.println(username + "둘째이름");
			response.setContentType("text/plain; charset=UTF-8");
			String last="username 서블렛 attribute로 받기:" + username + "요청방식: " + type2;
			response.getWriter().print(last);
			System.out.println(last);
		} else {
			response.sendRedirect("testServelt02.html");
		}
	}

	@Override
	public void destroy() {
		System.out.println("마지막단계");
	}

}
