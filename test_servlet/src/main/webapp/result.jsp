<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");
	String message2 = (String) session.getAttribute("message");
	String message3 = request.getParameter("message");
	%>
	<h2>결과값 받기</h2>
	<p>
		결과<%=message + "1/" + message2 + "2/" + message3 + "3/"%></p>
</body>
</html>