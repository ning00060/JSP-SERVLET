package com.tenco.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;
	private static final String CREATEUSER = " INSERT INTO users(username, password, email) VALUES (? , ?, ?) ";
	private static final String SELECTUBYUSERNAME = "select * from users where username=? ";
	private static final String SELECTBYID = "select * from users where id=? ";
	private static final String ALLSELCET = "select * from users";
	private static final String UPDATETODO = " update users set password = ?, email = ? where id= ? ";
	private static final String DELETETODO = " delete from users where id= ? ";

	public UserDAOImpl() {
		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int createUser(UserDTO userDTO) {
		int resultCount = 0;

		try (Connection conn = dataSource.getConnection()) {
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(CREATEUSER)) {
				pstmt.setString(1, userDTO.getUsername());
				pstmt.setString(2, userDTO.getPassword());
				pstmt.setString(3, userDTO.getEmail());
				resultCount = pstmt.executeUpdate();
				// 트랜잭션 커밋
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} // end of preparedstatement
		} catch (Exception e) {
			e.printStackTrace();
		} // end of connection

		return resultCount;
	}

	@Override
	public UserDTO selectUserByName(String name) {
		UserDTO userDTO = null;
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(SELECTUBYUSERNAME)) {
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					userDTO = new UserDTO();
					userDTO.setId(rs.getInt("id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setCreatedAt(rs.getString("created_at"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UserDTO: " + userDTO.toString());
		return userDTO;
	}

	@Override
	public UserDTO selectUserById(int id) {
		UserDTO userDTO = null;
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(SELECTBYID)) {
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					userDTO = new UserDTO();
					userDTO.setId(rs.getInt("id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setCreatedAt(rs.getString("created_at"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UserDTO: " + userDTO.toString());
		return userDTO;
	}

	@Override
	public List<UserDTO> Allselect() {
		// 자료 구조를 사용할때 일단 생성 시키자
		List<UserDTO> list = new ArrayList<UserDTO>();

		try (Connection conn = dataSource.getConnection()) {

			try (PreparedStatement pstmt = conn.prepareStatement(ALLSELCET)) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					UserDTO userDTO = new UserDTO();
					userDTO.setId(rs.getInt("id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setCreatedAt(rs.getString("created_at"));
					list.add(userDTO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("UserList All: " + list.toString());
		return list;
	}

	@Override
	public int updateUser(UserDTO userDTO, int id) {
		int rowCount = 0;
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(UPDATETODO)) {
				pstmt.setString(1, userDTO.getPassword());
				pstmt.setString(2, userDTO.getEmail());
				pstmt.setInt(3, id);
				rowCount = pstmt.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	@Override
	public int deleteUser(int id) {
		int rowCount = 0;

		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(DELETETODO)) {
				pstmt.setInt(1, id);
				rowCount = pstmt.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount;
	}

}
