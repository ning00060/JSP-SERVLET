<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션을 읽어 보는 페이지</title>
</head>
<body>
	<h2>세션 읽기</h2>
	<%
		// 삼항 연산자
		// if else
		// try catch
			try{
				
			
		String username= (String) session.getAttribute("username");
		int age= (int) session.getAttribute("age");
		
		if(username != null){
			out.print("<p> 안녕 "+ username+"</p>");			
			out.print(" <p>나이는 " + age + "입니다</>");
		}else{
			out.print("세션 설정이 되지 않았습니다.");
		}
			}catch(Exception e){
				response.sendRedirect("setSession.jsp");
			}
	%>
</body>
</html>