<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/resources/css/css.css"/>">

<header>
                <!-- header 시작 -->
                <h1>
                    <a href="<c:url value="/"/>"><img src="<c:url value="/resources/img/comm/logo.png"/>" alt="마이닥터"></a>
                </h1>
                <div class="right">
	                <sec:authorize access="hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')">
	                ${user.username }님! 
	                <a href="<c:url value="/j_spring_security_logout"/>" class="image" style="background-image: url(${user.profileUrl});">photo</a>
					<!--<a href="<c:url value="/j_spring_security_logout"/>">로그아웃</a>-->
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
						<a href="<c:url value="/member/login"/>">로그인</a>
					</sec:authorize>
                    
                    <input type="checkbox" id="bt_gnb">
                    <label for="bt_gnb">메뉴</label>
                </div>
                <!-- header 끝 -->
</header>