package com.tenco.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.tenco.util.DBUtil;

public class TodoTAOImpl implements TodoDAO{

	@Override
	public int addTodo(TodoDTO dto) {
		try (Connection conn = DBUtil.getConnection()){
			
			//TODO -- null값 필수 추가
			PreparedStatement pstmt = conn.prepareStatement(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<TodoDTO> getDTOByUserId(int LoginedUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodoDTO getDTOByTodoId(int TodoId, int LoginedUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDTO(int TodoId, int LoginedUserId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDTO(int TodoId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
