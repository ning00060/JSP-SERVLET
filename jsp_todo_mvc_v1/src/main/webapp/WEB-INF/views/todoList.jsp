<%@page import="com.tenco.model.UserDTO"%>
<%@page import="com.tenco.model.TodoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 목록</title>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>


<%-- 	<%
	List<TodoDTO> todoList = new ArrayList<TodoDTO>();
	todoList=(ArrayList) request.getAttribute("list");
	List<TodoDTO> idList = new ArrayList<TodoDTO>();
	 idList = (ArrayList)request.getAttribute("list2");
	if (todoList != null && !todoList.isEmpty()) {
	%> --%>
<c:choose>
	<c:when test="${not empty list }">
	


		<h2>할 일 목록</h2>
		<a href="todoForm"> 새 할일 추가</a>
	
		<table border="1">
			<tr>
				<th>제목</th>
				<th>지은이</th>
				<th>설명</th>
				<th>마감일</th>
				<th>완료 여부</th>
				<th>(액션-버튼)</th>
			</tr>
			<c:forEach var="todo" items="${list}">
			<tr>
				<td><c:out value="${todo.getTitle()}"/></td>
				<td><c:out value="${todo.getUsername()}"/></td>
				<td><c:out value="${todo.getDescription()}"/></td>
				<td><c:out value="${todo.getDueDate()}"/></td>
				<td><c:out value="${todo.getCompleted() eq '1'  ? '완료' : '미완료'}"/></td>
				<td><a href="detail?id=${todo.getId()}">상세보기</a>
					<form action="delete" method="get">
						<input type="hidden" name="id" value="${todo.getId()}">
						<button type="submit">삭제</button>
					</form></td>
			</tr>
		</c:forEach>
		</table>
	</c:when>	
	<c:otherwise>
	
	<hr>
	<p>등록된 할 일이 없습니다.</p>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${not empty list2}">
		<h2>본인 게시글 확인</h2>
		<table border="1">
			<tr>
				<th>제목</th>
				<th>설명</th>
				<th>마감일</th>
				<th>완료 여부</th>
				<th>(액션-버튼)</th>
			</tr>
			<c:forEach var="todo2" items="${list2}">
			<tr>
				<td><c:out value="${todo2.getTitle()}"/></td>
				<td><c:out value="${todo2.getDescription()}"/></td>
				<td><c:out value="${todo2.getDueDate()}"/></td>
				<td>${todo2.getCompleted() eq '1'  ? '완료' : '미완료'}</td>
				<td><a href="detail?id=${todo2.getId()}">상세보기</a>
					<form action="delete" method="get">
						<input type="hidden" name="id" value="${todo2.getId()}">
						<button type="submit">삭제</button>
					</form></td>
			</tr>
			</c:forEach>	
		</table>
	</c:when>
	<c:otherwise>
	
	<hr>
	<p>등록된 할 일이 없습니다.</p>
	</c:otherwise>
</c:choose>


</body>
</html>





