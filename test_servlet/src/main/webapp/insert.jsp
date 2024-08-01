<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insert 하기</h1>
	<form action="/ts1/insert"method="post">
		<label for="name">이름</label>
		<input type="text"id="name" name="name"value="홍길동">
	
		<label for="email">이메일</label>
		<input type="email"id="email" name="email"value="a@naver.com">
		
		<label for="age">나이</label>
		<input type="text"id="age" name="age">
		
		<button type="submit">제출</button>
	
	</form>
</body>
</html>