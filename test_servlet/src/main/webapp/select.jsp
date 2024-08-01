<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>데이터 조회</h2>
	<form action="/ts1/select2" method="get">
	<button type="submit" >전체 조회</button>
	</form>
	<hr>
	
	<h2>검색 조회</h2>
	<br>
	<form action="/ts1/select" method="get">
	<label for="name">이름</label>
	<input type="text" id="name"name="name" required="required">
	
	<label for="email">이름</label>
	<input type="email" id="email"name="email" >
	
	<label for="age">나이</label>
	<input type="text" id="age"name="age" >
	<button type="submit" >상세 조회</button>
	</form>
</body>
</html>