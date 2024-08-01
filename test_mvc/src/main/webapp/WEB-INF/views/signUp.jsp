<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Sing UP 화면입니다</h1>
	<div> 가입</div>
	
			<!--  signIn과 같은방식 -->
		<form action="${pageContext.request.contextPath}/user/signUp" method="post">
			<label for="username">이름</label>
			<input type="text" id="username" name="username" value="길동이">
			<label for="email">이메일</label>
			<input type="email" id="email" name="email" value="gg@nate.com">
			<label for="password">패스워드</label>
			<label for="email">Email </label>
			<input type="email" id="email" name="email" value="a@naver.com" required="required">
			<input type="password" id="password" name="password" >
			<button type="submit">제출</button>
		
		</form>
</body>
</html>