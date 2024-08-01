<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet"type="text/css"href="css/styles.css">
</head>
<body>
	<h2>게시글 목록</h2>
	<%
		ResultSet rs =(ResultSet) request.getAttribute("resultSet");
		if(rs != null){
			
	%>

	 <div class="card-container">
				<%
					while(rs.next()){
				%>
				

	 	<div class="card-selector">
	 	<h2><%= "--"+rs.getString("title")+ "--"%></h2>
	 		<ul>  
	 			<li><%= rs.getInt("id") %></li>
	 			<li><a href="view-post?boardId=<%=rs.getInt("id") %>"><%=rs.getString("title")%></a></li>
	 			<li><%= rs.getString("content") %></li>
	 			<li><%= rs.getString("created_at") %>	</li>
	 			<li>
	 				<form action="delete-post" method="get">
					<input type="hidden" name="boardId" value="<%=rs.getInt("id")%>">
					<button type="submit">삭제</button>
					</form>
				</li>
	 		</ul>	
	 	</div>

				<% } %>

	 	

 		<% } %>
	 </div>	
	 
	 	
	 
</body>
</html>