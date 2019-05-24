<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/member.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
<div class="wrap">
<header><c:import url="/inc/header"></c:import></header>
<div class="container_wrap">
<div class="container">
<!-- 컨텐츠 시작 -->
<h2 class="title">회원가입</h2>
<div id="join_complete" class="page member">
	<p>가입이 완료되었습니다. 감사합니다.</p>
	<a href="/" class="bt1">HOME</a>
</div>
<!-- 컨텐츠 끝 -->
</div>
</div>
<footer><c:import url="/inc/footer"></c:import></footer>
</div>
</body>
</html>