<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/member.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/table.css" />
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div class="wrap">
	<header><c:import url="/inc/header"></c:import></header>
	<div class="container_wrap">
	<div class="container">
	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="one_user">
				<tr>
					<td>${one_user.id }</td>
					<td>${one_user.username }</td>
					<td>${one_user.user_phon }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
	</div>
</body>
</html>