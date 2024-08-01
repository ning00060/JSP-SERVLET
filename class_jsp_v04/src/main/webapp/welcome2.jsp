<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영해요</title>
</head>
<body>
	<% 
	// http://localhost:8080/jsp/welcome.jsp

	String username= (String)session.getAttribute("username");	
	
	if(username==null|| username.trim().isEmpty()){
			session.setAttribute("username", "홍길동");
			session.setAttribute("visitCount", 1);	

	} else{
		Integer visitCount= (Integer)session.getAttribute("visitCount");
		if(visitCount==null){
			visitCount=1;
		}else{
		}
	}
	
	%>
	
	<h2>환영 합니다,<%= username %> </h2>
</body>
</html>