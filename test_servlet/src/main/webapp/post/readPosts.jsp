<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	margin: 0;	
	padding: 0;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	height: 100vh;
	flex-direction: column;
	font-family: Arial,sans-serif;
}
.post{
	display: flex;
	flex-wrap: wrap;
	gap:20px; /* 카ㅣ드들 사이에 간격 속성*/
	padding: 20px;
	
	}
.poster{
	display:flex;
	flex-direction:column;
	flex: 1 1 calc(33.333% - 80px);
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 8px;
	/* 수평 0, 수직 2px ,흐림반경 4px 그림자 색상 10% */
	box-shadow: 0 2px 4px rgba(0,0,0,0.5);
	padding: 20px;
	justify-content: center;
	}
	h2{
	display:flex;
	justify-content: center;
	}

</style>
</head>
<body>
	<h2>게시글 목록</h2>
	
	<% 
	ResultSet rs=(ResultSet)	request.getAttribute("resultSet");
		if(rs !=null){
			
	%>
		<div class="post">
		
	<%
		while(rs.next()){
	%>
		<div class="poster">
			<h2><%= rs.getString("title") %></h2>
				<ul>
					<li><%=rs.getString("id") %></li>
					<li><%=rs.getString("content") %></li>
					<li><%=rs.getString("created_at") %></li>
					<li><form action="delete-post" method="post" >
							<input type="hidden" name="boardId" value=<%= rs.getString("id") %>>
							<button type="submit">삭제</button>				
						</form>
					</li>
				
				</ul>
		</div>
		
	
		<% } %>
	<% }%>	
		</div>
	
</body>
</html>