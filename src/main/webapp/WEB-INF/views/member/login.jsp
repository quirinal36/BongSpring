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
<h2 class="title">로그인</h2>
<div id="login" class="member">
	<form class="form1" action="<c:url value="${ctx}/j_spring_security_check"/>" method="post">
		<dl>
			<dt>아이디</dt>
			<dd><input type="text" name="loginid" value="${loginid }" required/></dd>
		</dl>
		<dl>
			<dt>비밀번호</dt>
			<dd><input type="password" name="loginpwd" 	placeholder="비밀번호를 입력하세요." required 
						value="${loginpwd }"/></dd>
		</dl>
		<c:if test="${not empty securityexceptionmsg }">
			<span id="error_msg" class="error" >${securityexceptionmsg}</span>
		</c:if>
		<input type="hidden" name="loginRedirect" value="${loginRedirect }"/>
		<input type="submit" value="로그인" class="bt1" />
	</form>
	<a href="/member/find">아이디/비밀번호 찾기</a>
	<a href="/member/join_step2">회원가입</a>
</div>
<!-- 컨텐츠 끝 -->
</div>
</div>
<footer><c:import url="/inc/footer"></c:import></footer>
</div>
</body>
</html>