<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과 확인 페이지</h2>
	<% 
	String message=request.getParameter("message");
	if(message.equals("create-success")){
		out.print("게시글 작성 성공");
	}else if(message.equals("delete-success")){
		out.print("게시글 삭제 성공");
	}
		%>
	
	<a href="createPost.jsp">게시글 작성 페이지</a>
	<a href="read-post">게시글 리스트 페이지</a>
</body>
</html>