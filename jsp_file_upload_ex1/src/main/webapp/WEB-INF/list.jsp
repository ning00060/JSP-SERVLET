<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이미지 리스트 출력하기</h1>
	<ul>
	<% 
	
	List<String> fileNames=(List<String>) request.getAttribute("fileNames");
	if(fileNames != null && !fileNames.isEmpty()){
		// 파일명들이 존재한다면
		for(String fileName : fileNames){
			%> 
			<li><img alt="" src="images/<%=fileName%>" width="200px"></li> 
			<%
		}
	}
	
	
	%>
	
	</ul>
	
</body>
</html>