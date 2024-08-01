package com.tenco.tboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.tboard.model.Comment;
import com.tenco.tboard.repository.interfaces.CommentRepository;
import com.tenco.tboard.util.DBUtil;

public class CommentRepositoryImpl implements CommentRepository {

	private static final String ADD_COMMENT_SQL = " INSERT INTO comments(board_id,user_id,content) VALUES(?,?,?) ";
	private static final String GET_COMMENT_SQL = " SELECT * FROM comments WHERE board_id=? and user_id=? ";

	@Override
	public void addComment(Comment comment) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(ADD_COMMENT_SQL)) {
				pstmt.setInt(1, comment.getBoardId());
				pstmt.setInt(2, comment.getUserId());
				pstmt.setString(3, comment.getContent());
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

	@Override
	public void updateComment(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comment getCommentByIdUserId(int id, int userId) {
		Comment comment = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_COMMENT_SQL)) {

			pstmt.setInt(1, id);
			pstmt.setInt(2, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					comment = Comment.builder().id(rs.getInt("id")).boardId(rs.getInt("board_id"))
							.userId(rs.getInt("user_id")).content(rs.getString("content"))
							.createdAt(rs.getTimestamp("created_at")).build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public List<Comment> getCommentByIdUsersId(int id, int userId) {
		List<Comment> commentList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_COMMENT_SQL)) {

			pstmt.setInt(1, id);
			pstmt.setInt(2, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					commentList.add(Comment.builder().id(rs.getInt("id")).boardId(rs.getInt("board_id"))
							.userId(rs.getInt("user_id")).content(rs.getString("content"))
							.createdAt(rs.getTimestamp("created_at")).build());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentList;
	}

	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return null;
	}

}
