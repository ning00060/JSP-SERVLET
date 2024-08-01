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
		<h2>세션</h2>
		<%
			String username=(String) session.getAttribute("username");
			String password=(String) session.getAttribute("password");
			String age=(String) session.getAttribute("age");
			
			if(username==null|| username.trim().isEmpty()){
				response.sendRedirect("testSession01.jsp");
			} else{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("age", age);
				
			
				%>
		<p>아이디는:
				<%= username %>
			비밀번호:	
			<%= password  %>
			나이:	
			<%= age  %>
		</p>
		<a href="testSession01.jsp">취소</a>
		<%
		/* session.invalidate(); */
		}
			 %>
	</div>
</body>
</html>