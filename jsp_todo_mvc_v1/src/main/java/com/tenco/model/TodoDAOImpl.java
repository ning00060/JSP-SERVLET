package com.tenco.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TodoDAOImpl implements TodoDAO {

	
	private DataSource dataSource;
	private static final String ADDTODO=" INSERT INTO todos(user_id,title,description,due_date,completed) values(?,?,?,?,?) ";
	private static final String GETTODOBYID=" SELECT * FROM todos WHERE id= ? ";
	private static final String GETTODOBYUSERID=" SELECT * FROM todos WHERE user_id= ? ";
	private static final String GETALLTODOS=" select t.id,title,description,t.created_at,due_date,completed,user_id,username "+ " from todos as t "+ " join users as u on t.user_id=u.id  ";
	private static final String UPDATETODO=" update todos set title = ?, description = ? "+ " ,due_date = ? , completed= ? where id= ? and user_id = ?  ";
	private static final String DELETETODO=" DELETE FROM todos WHERE id=? and user_id=?";
	
	
	
	public TodoDAOImpl() {
		try {
			InitialContext ctx;
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addTodo(TodoDTO todoDTO, int principalId) {
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(ADDTODO)) {
				pstmt.setInt(1, principalId);
				pstmt.setString(2, todoDTO.getTitle());
				pstmt.setString(3, todoDTO.getDescription());
				pstmt.setString(4, todoDTO.getDueDate());
				pstmt.setBoolean(5,Boolean.parseBoolean(todoDTO.getCompleted()));
				pstmt.executeUpdate();

				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public TodoDTO getTodoById(int id) {
		TodoDTO dto= new TodoDTO();
		try (Connection conn = dataSource.getConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(GETTODOBYID);
			pstmt.setInt(1, id);
			
			try (ResultSet rs=pstmt.executeQuery()) {
				if( rs.next()){
					dto.setId(rs.getInt("id"));
					dto.setUserId(rs.getInt("user_id"));
					dto.setTitle( rs.getString("title"));
					dto.setDescription( rs.getString("description"));
					dto.setDueDate( rs.getString("due_date"));
					dto.setCompleted( rs.getString("completed"));
					
				}
			} catch (Exception e) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public List<TodoDTO> getTodosByUserId(int userId) {
		List<TodoDTO> list= new ArrayList<TodoDTO>();
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(GETTODOBYUSERID)) {
				pstmt.setInt(1, userId);
				ResultSet rs=pstmt.executeQuery();
				while( rs.next()){
					TodoDTO todoDTO=new TodoDTO();
					todoDTO.setId(rs.getInt("id"));
					todoDTO.setUserId(rs.getInt("user_id"));
					todoDTO.setTitle( rs.getString("title"));
					todoDTO.setDescription( rs.getString("description"));
					todoDTO.setDueDate( rs.getString("due_date"));
					todoDTO.setCompleted( rs.getString("completed"));
					list.add(todoDTO);
					
				}
			} catch (Exception e) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<TodoDTO> getAllTodos() {
		List<TodoDTO> list= new ArrayList<TodoDTO>();
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(GETALLTODOS)) {
				ResultSet rs=pstmt.executeQuery();
		
				while( rs.next()){
					System.out.println("1");
					TodoDTO todoDTO=new TodoDTO();
					todoDTO.setId(rs.getInt("id"));
					todoDTO.setTitle( rs.getString("title"));
					todoDTO.setDescription( rs.getString("description"));
					todoDTO.setDueDate( rs.getString("due_date"));
					todoDTO.setCompleted( rs.getString("completed"));
					todoDTO.setUsername(rs.getString("username"));
					list.add(todoDTO);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void updateTodo(TodoDTO todoDTO, int principalId) {
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATETODO)) {
				pstmt.setString(1, todoDTO.getTitle());
				pstmt.setString(2, todoDTO.getDescription());
				pstmt.setString(3, todoDTO.getDueDate());
				pstmt.setBoolean(4, Boolean.parseBoolean(todoDTO.getCompleted()));
				pstmt.setInt(5, todoDTO.getId() );
				pstmt.setInt(6, principalId );
				pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	/*
	 * 삭제기능
	 * id= todos pk 
	 * principanId= 세션 id
	 */
	
	
	@Override
	public void deleteTodo(int id, int principalId) {
		try (Connection conn=dataSource.getConnection()){
				conn.setAutoCommit(false);
				try (PreparedStatement pstmt= conn.prepareStatement(DELETETODO)){
					
					pstmt.setInt(1, id);
					pstmt.setInt(2, principalId);
					pstmt.executeUpdate();
					
					conn.commit();
				} catch (Exception e) {
					conn.rollback();
					e.printStackTrace();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
