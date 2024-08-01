package com.tenco.tboard.controller;

import java.io.IOException;
import java.util.List;

import com.tenco.tboard.model.Board;
import com.tenco.tboard.model.Comment;
import com.tenco.tboard.model.User;
import com.tenco.tboard.repository.CommentRepositoryImpl;
import com.tenco.tboard.repository.interfaces.CommentRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/comment/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentRepository commentRepository;

	public CommentController() {
		commentRepository = new CommentRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession(false);
		System.out.println(action);

		if (session == null || session.getAttribute("principal") == null || session.getAttribute("board") == null) {
			response.sendRedirect(request.getContextPath() + "/user/signin");
			return;
		}
		switch (action) {
		case "/add":
			handelAddCommentForm(request, response, session);
			break;

		case "/delete":
			break;
		case "/update":

			break;
		case "/list":
			// handleListBoards(request,response,session);
			break;
		case "/view":
			// showViewBoard(request,response,session);
			break;
		case "/deleteConmment":
			// handleDeleteComment(request,response,session);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void handelAddCommentForm(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException, ServletException {
		String content = request.getParameter("content");
		User principal = (User) session.getAttribute("principal");
		Board board = (Board) session.getAttribute("board");
		System.out.println("principal:" + principal);
		System.out.println("board:" + board);
		if (content != null) {
			Comment comment = Comment.builder().boardId(board.getId()).userId(principal.getId()).content(content)
					.build();
			commentRepository.addComment(comment);
			List<Comment> comments=commentRepository.getCommentByIdUsersId(board.getId(), principal.getId());
			System.out.println("코멘트 추가 완료");
			request.setAttribute("username", principal.getUsername());
			request.setAttribute("comments", comments);
			System.out.println(comments.toString());
			request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);
		}

	}

}
