<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP MVC 게시판</title>
<style type="text/css">
body {
	font-family: arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
	margin: 0;
	padding: 0;
}

.nav-list {
	list-style-type: none;
	padding: 0;
} 
.nav-list li{
	margin: 10px;
	display: inline-block;
} 
.nav-list li a{
	text-decoration: none;
	padding: 10px 20px;
	color: black;
} 
.btn-primary{
	background-color: #007bff;
}
.btn-secondary{
	background-color: #6c757d;
}
</style>
</head>
<body>
	<div class ="container">
		<h2> JSP MVC 게시판 테스트 페이지</h2>
		<ul class="nav-list">
			<!-- servlet 의 webservlet으로 보내지는 경로중 /user/* -> 부분이 href경로의 user뒷부분 -->					
			<li class="btn btn-primary"><a href="${pageContext.request.contextPath}/user/signUp">회원가입</a></li>
			<li class="btn btn-primary"><a href="${pageContext.request.contextPath}/user/signIn">로그인</a></li>
			<li class="btn btn-secondary"><a href="${pageContext.request.contextPath}/user/signOut">로그아웃</a></li>
		</ul>
	</div>
</body>
</html>