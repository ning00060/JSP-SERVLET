<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: #f0f0f0;
display: flex;
flex-direction: column;
}
header{
background-color: black;
color: white;
display: flex;
justify-content: space-between;
align-items: center;

}

h2{
margin-left: 20px;
}

ul{
list-style-type: none;
display: flex;
}

li{
margin-right: 20px;
}
	
footer{
	background-color: #f0f0f0;
	display:flex;
	padding: 20px;
	border-radius: 8px;
	height:70vh;
	justify-content:center;
	width: 100%;
	
	}
.cm{

	align-content:flex-end;
	width: 300px;	
	
}
.input{
	width: 90%;
	margin-bottom: 20px;
}

</style>
</head>
<body>
	<header>
		
			<h2>인치 변환기</h2>
			
			<nav>
				<ul>
					<li>홈</li>
					<li>로그인</li>
				</ul>
			</nav>
		
	</header>
	
	<footer>
	 	<form class="cm">
	 	<h1>변환결과</h1>
	 	
		<p>
		
		<%
			String cmStr=request.getParameter("cm");
			double cm=Integer.valueOf(cmStr);
			out.print(cm+"cm는"+String.format("%.2f",(cm/2.54))+"인치입니다");
		%>
		
		</p>
			<a href="form_page.jsp">돌아가기</a>
	 	</form>

	</footer>
</body>
</html>