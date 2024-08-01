<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
		<h2>게시글 작성</h2>
		<form action="create-post" method="post">
			<label for="title">제목:</label>
			<input type="text" id="title"name="title"value="게시글작성">
			<br>
			
			<label for="content">내용:</label>
			<input type="text" id="content"name="content"value="jsp 웹 프로그래밍">
			<button type="submit">글 작성</button>
			<br>
			<a href="read-post">게시글 목록</a>
			
		
		</form>
</body>
</html>