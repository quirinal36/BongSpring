<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<header>
	<div>
		<ul>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/admin"/>">관리자화면</a></li>
			</sec:authorize>
			<li><a href="<c:url value="/board/list"/>">게시판</a></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/photoInfo/list"/>">환자사진</a></li>
				<li><a href="<c:url value="/oprecord/list"/>">수술기록지</a></li>
			</sec:authorize>
			
			
		</ul>
		
		<sec:authorize access="hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')">
			<a href="<c:url value="/j_spring_security_logout"/>">로그아웃</a>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
			<a href="<c:url value="/member/login"/>">로그인</a>
		</sec:authorize>
	</div>
</header>