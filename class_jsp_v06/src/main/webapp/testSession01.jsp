<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2> 세션 쓰기</h2>
		<form action="testSession02.jsp"method="post">
			<label for ="username">username:</label>
			<input type="text" id="username" name="username" value="홍길동">
			<label for ="password">password:</label>
			<input type="password" id="password" name="password" value="1234">
			<label for ="age">나이:</label>
			<input type="text" id="age" name="age" value="1234">
			<button type=submit>넘기기</button>
			
		</form>
	</div>
</body>
</html>