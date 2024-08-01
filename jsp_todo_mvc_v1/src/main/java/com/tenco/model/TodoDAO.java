package com.tenco.model;

import java.util.List;

public interface TodoDAO {

	// 저장기능
	void addTodo(TodoDTO todoDTO, int principalId);

	TodoDTO getTodoById(int id);
	// 사용자 아이디 기준으로 todoList

	List<TodoDTO> getTodosByUserId(int userId);

	List<TodoDTO> getAllTodos();

	void updateTodo(TodoDTO todoDTO, int principalId);

	void deleteTodo(int id, int principalId);

}
