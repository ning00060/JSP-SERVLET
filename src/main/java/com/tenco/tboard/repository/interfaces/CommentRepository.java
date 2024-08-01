package com.tenco.tboard.repository.interfaces;

import java.util.List;

import com.tenco.tboard.model.Comment;

public interface CommentRepository {

	void addComment(Comment comment);

	void updateComment(Comment comment);

	void deleteComment(int id);

	Comment getCommentByIdUserId(int id,int userId);

	List<Comment>  getCommentByIdUsersId(int id, int userId); 
	
	List<Comment> getAllComment();
}
