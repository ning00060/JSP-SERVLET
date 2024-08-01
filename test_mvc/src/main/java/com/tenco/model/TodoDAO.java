package com.tenco.model;

import java.util.List;

public interface TodoDAO {

	public int addTodo(TodoDTO dto);
	public List<TodoDTO> getDTOByUserId(int LoginedUserId);
	public TodoDTO getDTOByTodoId(int TodoId,int LoginedUserId);
	public int updateDTO(int TodoId,int LoginedUserId);
	public int deleteDTO(int TodoId);
	
	
}
