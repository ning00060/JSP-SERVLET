package com.tenco.controller;

import java.io.IOException;

import com.tenco.model.TodoDAO;
import com.tenco.model.TodoTAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 루트를 같게하면 namingContext오류가 뜬다 주의하자
@WebServlet("/todo/*")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoDAO todoDAO;

	// init() 와 생성자 사용의 차이가 있는지!
	public TodoController() {
		todoDAO = new TodoTAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/list":
			
			// 방식은 이해 했지만  코드를 sql코드에 추가해서 만드는것인지
			// 또한 html에서 추가해야할 코드가 정확히 떠오르지못함
			handleListBoards(request,response);
			break;
		}
		switch (action) {
		case "/create":
			break;
			
		default:
			break;
		}

	}
		private void handleListBoards(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int page=1; 
			int pageSize= 3;
			
			try {
				
				String pageStr=request.getParameter("page");
				if(pageStr !=null) {
					page = Integer.parseInt(pageStr);
				}
			} catch (Exception e) {
				page= 1;
			}
			int offset = (page -1) * pageSize ;
			
			System.out.println("page : " + page);
			System.out.println("offset : " + offset);
			request.getRequestDispatcher("/WEB-INF/views/todoList.jsp").forward(request, response);
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
