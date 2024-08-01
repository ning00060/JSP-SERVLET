<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 결과</title>
</head>
<body>
	<h1>구구단 결과</h1>
	<% 
		String sessSionId=session.getId();
		out.print("sessionid:"+ sessSionId);
		
		String numberStr= request.getParameter("number");
		int number=Integer.parseInt(numberStr);
	%>
		<h2><%=number %> 단</h2>
		
		<table border="1">
			<thead>
				<tr>
					<th>계산식</th>
					<th>결과</th>
				</tr>
			</thead>
			<tbody>
				<% for(int i=1;i<=9;i++){%>
				<tr>
					<td><%= number %>x <%= i %></td>
					<td><%= number * i%>x </td>
				</tr>
				<%} %>			
			</tbody>
		</table>
</body>
</html>