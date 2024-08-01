<%@page import="com.tenco.model.UserDTO"%>
<%@page import="com.tenco.model.TodoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>

	<div class="navbar">
		<a href="#" class="nav-item">홈</a> <a href="list" class="nav-item">소개</a>
		<a href="#" class="nav-item">서비스</a> <a href="#" class="nav-item">연락처</a>
	</div>

	<div class="main-container">
		<div class="box">상세 보기 화면</div>
	</div>

	<div class="card-container">

		<div class="card">
			<h2>${todoDTO.getTitle()}</h2>
			<p>${todoDTO.getId()}</p>
			<p>${todoDTO.getTitle()}</p>
			<p>${todoDTO.getDescription()}</p>
			<p>${todoDTO.getDueDate()}</p>
			<p>${todoDTO.getCompleted()}</p>
			<br>
		</div>
		<hr>
	</div>	
		
	<div class="card-container">

		<div class="card">
			<form action="update" method="post">
					<input type="hidden" name="id"value="${todoDTO.getId()}">
					<label for="title">제목:</label>
					<input type="text" id="title"name="title"value="${todoDTO.getTitle()}">
					<br><br>
					<label for="description">설명:</label>
					<textarea rows="30" cols="50" id="description"name="description">
						${todoDTO.getDescription()}
					</textarea>
					<br><br>
					<label for="dueDate">마감기한:</label>
					<input type="date" id="dueDate"name="dueDate"value="${todoDTO.getDueDate()}">
					<br><br>
					<label for="completed">완료 여부:</label>
					<input type="checkbox" id="completed"name="completed" 
					<c:if test="${todoDTO.getCompleted() eq '1'}">checked</c:if>>

				
					
					
					<br><br>
					<button type="submit">수정하기</button>
				</form>
				<br><br>
				<a href="list">목록으로 돌아가기</a>
		</div>
	</div>
</body>
</html>