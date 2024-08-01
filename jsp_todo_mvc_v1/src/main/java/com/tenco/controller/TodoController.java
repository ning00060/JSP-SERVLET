package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import com.tenco.model.TodoDAO;
import com.tenco.model.TodoDAOImpl;
import com.tenco.model.TodoDTO;
import com.tenco.model.UserDAO;
import com.tenco.model.UserDAOImpl;
import com.tenco.model.UserDTO;

// .../mvc/todo/xxx

@WebServlet("/todo/*")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoDAO todoDAO;
	
       
    public TodoController() {
    	todoDAO = new TodoDAOImpl();
    }

    // http://localhost:8080/mvc/todo/todoForm
    // http://localhost:8080/mvc/todo/form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getPathInfo();
		System.out.println("action : "+ action);
		
		HttpSession session=request.getSession();
		session.getAttribute("principal");
		UserDTO principal=(UserDTO) session.getAttribute("principal");
		
		if(principal==null) {
			// 로그인을 안한 상태 
			response.sendRedirect("/mvc/user/signIn?message=invalid");
			return;
		} 
		

		switch (action) {
		case "/todoForm":
			todoFormPage(request,response);
			
			break;
		case "/list":
			todoListPage(request,response,principal);
			
			break;
		case "/detail":
			todoDetailPage(request,response,principal);
			break;
		case "/delete":
			deleteTodo(request,response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}
	
	/**
	 * todo 삭제 기능
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action= request.getPathInfo();
		System.out.println("action : "+ action);
		HttpSession session=request.getSession();
		session.getAttribute("principal");
		UserDTO principal=(UserDTO) session.getAttribute("principal");
		
		try {
			int todoId= Integer.parseInt(request.getParameter("id")) ;
			todoDAO.deleteTodo(todoId, principal.getId());
			
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+ "/todo/list?error=invalid");
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+ "/todo/list");
	}
	
	// http://localhost:8080/mvc/todo/detail?id=2
	private void todoDetailPage(HttpServletRequest request, HttpServletResponse response,UserDTO principal) throws IOException, ServletException {
	HttpSession session=request.getSession();
	try {
		String todoId=  request.getParameter("id");
		TodoDTO todoDTO = todoDAO.getTodoById(Integer.parseInt(todoId));
		request.setAttribute("todoDTO", todoDTO);
		if(todoId == null ) {
			response.sendRedirect(request.getContextPath()+ "/user/signIn?message=invalid");
			return;
		}
		System.out.println("todoDTO "+todoDTO.toString());
		if(todoDTO.getUserId()== principal.getId()) {
			
			request.getRequestDispatcher("/WEB-INF/views/todoDetail.jsp").forward(request, response);	
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script> alert('권한이 없습니다.'); history.back(); </script>");
		}
	} catch (Exception e) {
		response.sendRedirect(request.getContextPath()+"/todo/list?error=invalid");
	}
	}
	

	// 


	// http://localhost:8080/mvc/todo/list
	/* 사용자별 
	 * @param  
	 * *
	 */
	private void todoListPage(HttpServletRequest request, HttpServletResponse response,UserDTO principal) throws IOException, ServletException {
		// 인증 검사

		List<TodoDTO> list=	todoDAO.getAllTodos();
		request.setAttribute("list", list);
		List<TodoDTO> list2=	todoDAO.getTodosByUserId(principal.getId());
		request.setAttribute("list2", list2);
		
		System.out.println("리스트 :"+list2.toString());
		System.out.println("request.getContextPath()"+ request.getContextPath());
		// request.getPathInfo() --> URL 요청에 있어 데이터 추출
		// request.getParameter() --> URL 요청에 있어 데이터 추출
		// request.getAttribute() --> 뷰를 내릴 속성에 값을 받아서 뷰로 내릴 때 사용
		// todoList.jsp 페이지로 내부에서 이동 처리
		
		System.out.println(list.toString());
		request.getRequestDispatcher("/WEB-INF/views/todoList.jsp").forward(request, response);
	}

	/*
	 * todo 
	 * 
	 * */
	private void todoFormPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		request.getRequestDispatcher("/WEB-INF/views/todoForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		UserDTO principal=(UserDTO) session.getAttribute("principal");
		String action= request.getPathInfo();
		switch (action) {
		case "/add":
			todoAddPage(request,response,principal);
			break;		

		case "/update":
			todoUpdatePage(request,response,principal);
			break;

		default:
			break;
		}
	}

	private void todoUpdatePage(HttpServletRequest request, HttpServletResponse response,UserDTO principal) throws IOException, ServletException {
		System.out.println(principal.toString());
		try {
			int todoId=Integer.parseInt(request.getParameter("id"));
			String title=request.getParameter("title");
			String description=request.getParameter("description");
			String dueDate=request.getParameter("dueDate");
//			String completed =null;
			String completed=request.getParameter("completed");
			System.out.println(request.getParameter("completed"));
			if (request.getParameter("completed") == null) {
				completed="false";				
			}else {
				
				completed="true";
			}
			TodoDTO todoDTO=TodoDTO.builder()
					.id(todoId)
					.userId(principal.getId())
					.title(title)
					.description(description)
					.dueDate(dueDate)
					.completed(completed)
					.build();
			todoDAO.updateTodo(todoDTO, principal.getId());
			
			System.out.println("업데이트 내역:" +todoDTO.toString());
			request.getRequestDispatcher("/WEB-INF/views/todoList.jsp").forward(request, response);
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script> alert('권한이 없습니다.'); history.back(); </script>");
		}
		
		

	}

	private void todoAddPage(HttpServletRequest request, HttpServletResponse response,UserDTO principal) {

		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String dueDate=request.getParameter("dueDate");
		String completed=request.getParameter("completed");
		System.out.println("completed 상태 "+ completed);
		if(completed==null) {
			completed="false";
			
		}
		TodoDTO todoDTO=TodoDTO.builder()
				.title(title)
				.description(description)
				.dueDate(dueDate)
				.completed(completed)
				.build();
		
		// principal -- null 이라면 --> 로그인 페이지로 이동 처리
		System.out.println(todoDTO.toString());
		todoDAO.addTodo(todoDTO, principal.getId());
		System.out.println(principal.toString());
		
		
	}
	

}
