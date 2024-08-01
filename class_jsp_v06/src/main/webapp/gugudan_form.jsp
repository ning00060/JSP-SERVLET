<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 폼</title>
</head>
<body>
	<%
		String mHidden="홍길동";
	
	
	%>
	<h1>구구단에 사용할 숫자를 입력 하세요</h1>
	<form action="result.jsp" method="get">
		<input type="hidden" name="mHidden"value="<%= mHidden%>">
		<input type="number" name="number">
		<input type="submit">제출
	
	</form>
</body>
</html>