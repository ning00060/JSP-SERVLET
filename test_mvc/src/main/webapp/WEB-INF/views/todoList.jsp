<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 목록</h2>
	
	<div class="action">
		<a href="${pageContext.request.contextPath}/todo/create">새글 작성하기</a>
		<a href="${pageContext.request.contextPath}/index.jsp">홈 화면</a>
	</div>
	
	<!--  board list 생성 -->
	<!--  반복문 사용 예정 -->
	<div class="board-item">
	
	</div>
	
	<div>
		<span><a href="${pageContext.request.contextPath}/todo/list?page=1">1</a></span><br>
		<span><a href="${pageContext.request.contextPath}/todo/list?page=2">2</a></span><br>
		<span><a href="${pageContext.request.contextPath}/todo/list?page=3">3</a></span><br>
		<span><a href="${pageContext.request.contextPath}/todo/list?page=4">4</a></span><br>
	</div>
</body>
</html>