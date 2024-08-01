<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
  <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        }

        .container {
            display: flex;
            flex-direction: column;
            background: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            animation: fadeIn 1s ease-in-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        .container label {
            margin-bottom: 10px;
            font-weight: bold;
            color: #555;
        }

        .container input[type="text"],
        .container input[type="password"] {
            padding: 12px;
            margin-bottom: 20px;
            border: none;
            border-radius: 25px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 100%;
            font-size: 16px;
            transition: box-shadow 0.3s ease;
        }

        .container input[type="text"]:focus,
        .container input[type="password"]:focus {
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            outline: none;
        }

        .container button {
            padding: 12px;
            background-color: #667eea;
            color: white;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .container button:hover {
            background-color: #764ba2;
        }

        .container .error-message {
            color: red;
            margin-bottom: 15px;
            text-align: center;
        }

        .container .signup-link {
            text-align: center;
            margin-top: 20px;
            color: #555;
        }

        .container .signup-link a {
            color: #667eea;
            text-decoration: none;
            font-weight: bold;
        }

        .container .signup-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
		<h2>로그인</h2>
		<!--  에러 메세지 출력 -->
<%-- 		<%
			 String success= (String) request.getParameter("message");
			
		%> --%>
		<c:choose>
			<c:when test="${not empty message }">
				
				<p style="color: red"><c:out value="${message}"/>  </p>
			
			</c:when>
			<c:otherwise>
			<!--  절대 경로 사용 해보기 -->
			<form action="/mvc/user/signIn" method="post">
				<label for="username">사용자 이름:</label>
				<input type="text" id="username" name="username" value="야스오1">
				<label for="password">사용자 비밀번호:</label>
				<input type="password" id="password" name="password" value="1234">
				<br>
				<button type="submit">로그인</button>
			</form>
			</c:otherwise>
		</c:choose>
	 </div>
</body>
</html>