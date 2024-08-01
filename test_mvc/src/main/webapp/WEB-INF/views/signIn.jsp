<%@page import="com.tenco.model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
		<!--  dispatcher 로 받아옴 -->
	<h2>로그인 JSP 파일 입니다</h2>
	
	<div>
		<!--  유저servlet으로 post형식을 보냄 -->
		<form action="${pageContext.request.contextPath}/user/signIn" method="post">
			<div class="input-group mb-3">
			  <label class="input-group-text" for="username">ID</label>
			  <input type="text" class="form-control"  id="username"  name="username" value="홍길동" required="required">
			</div>
			
			<div class="input-group mb-3">
			  <label class="input-group-text" for="password">PW</label>
			  <input type="text" class="form-control" id="password"  name="password" value="asd123" required="required">
			</div>
			<button type="submit">로그인</button>
		</form>
	</div>
</body>
</html>