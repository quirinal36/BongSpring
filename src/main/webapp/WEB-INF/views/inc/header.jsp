<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<header>
	<div>
		<ul>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="/admin">관리자화면</a></li>
			</sec:authorize>
			<li><a href="/board/list">게시판</a></li>
			<li><a href="#">메뉴2</a></li>
		</ul>
		
		<sec:authorize access="hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')">
			<a href="/j_spring_security_logout">로그아웃</a>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
			<a href="/member/login">로그인</a>
		</sec:authorize>
	</div>
</header>