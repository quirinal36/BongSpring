<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/member.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
</head>
<body>
<div id="wrap">
<header><c:import url="/inc/header"></c:import></header>
<div id="container_wrap">
<div id="container">
<!-- 컨텐츠 시작 -->
<h2 class="title">회원가입</h2>
<div class="step">
	<div><span>01</span>본인인증</div>
	<div><span>02</span>정보입력</div>
	<div class="on"><span>03</span>가입완료</div>
</div>
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