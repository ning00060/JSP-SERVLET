package com.tenco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.tenco.model.UserDAO;
import com.tenco.model.UserDAOImpl;
import com.tenco.model.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO;

	@Override
	public void init() throws ServletException {
		userDAO = new UserDAOImpl();
	}

	// ex) pageContext.request.contextPath()+/user/*  *부분이 받아오는부분
	// 겟으로받아옴  form 에서 보내는 post 이외는 대부분 get 으로 받아옴
	// --> dispatcher,sendredirect 또한 get 으로만 보내지는건가 post 로 보내는 코드는없을까
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/signIn":
			// sendredirect 와 정확한 차이를 이해못함
			request.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(request, response);
			break;
		case "/signUp":
			request.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(request, response);
			break;
		case "/signOut":
			signOut(request,response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}
	
	private void signOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		System.out.println("로그아웃 성공");
		response.sendRedirect(request.getContextPath());
}

	// http://localhost:8080/mvc/user/signUp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		switch (action) {
		case "/signIn":
			signIn(request, response);
			break;
		case "/signUp":
			signUp(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}



	/**
	 * 로그인 기능
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	
	// signIn.jsp에서 post로 보내온부분을 case문 "/signIn/" 으로 받아옴
	private void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String usename = request.getParameter("username");
		String password = request.getParameter("password");

		UserDTO userDTO = userDAO.selectUserByName(usename);
		HttpSession session = request.getSession();
		
		// getparameter 로 jsp 에서 보낸 데이터를 받아옴
		// username 데이터확인과 패스워드빈공간없는지까지확인
		if (usename == null && password.trim().isEmpty()) {
			
			// "" 부분 html 코드 적용되는공식
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (usename == null) {
				out.println("<script> alert('잘못된 정보 입니다'); history.back();  </script>");
			}
		}

		else {

			session.setAttribute("userDTO", userDTO);
			response.sendRedirect(request.getContextPath() + "/todo/list");

		}

	}

	/*
	 * 회원 가입 기능
	 * @param request
	 * @param response
	 */
	//signIn과 같은방식으로 받아옴
	private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인증 검사 필요 없는 기능

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// 방어적 코드 작성
		if (username == null || username.trim().isEmpty()) {
			request.setAttribute("errorMessage", "사용자 이름을 입력하시오");
			request.getRequestDispatcher("/WEB-INF/signUp.jsp").forward(request, response);
			return;
		}
		
		//create 방법으로 
		//builder 를 통해 필요한 데이터만 add 할수있음
		UserDTO userDTO = UserDTO.builder().username(username).password(password).email(email).build();
		int resultRowCount = userDAO.createUser(userDTO);
		System.out.println("resultRowcount : " + resultRowCount);

		
		if (resultRowCount == 1) {
			System.out.println("i으로 보내짐");
			request.getRequestDispatcher("signIn").forward(request, response);
		} else {
			response.sendRedirect("user/signUp?message=error");

		}
	}

}
