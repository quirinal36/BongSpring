<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/resources/css/css.css"/>">
    <script src="<c:url value="/resources/js/index.js"/>"></script>
    <script src="<c:url value="/resources/js/common.js"/>"></script>
    
<header>
     <footer>
                <!-- footer 시작 -->
                <div id="fixedMenu">
                    <a href="<c:url value="/list"/>" class="home">홈</a>
                    <a href="#" class="notice">진료안내</a>
                    <a href="<c:url value="/myGroup"/>" class="info">내 그룹</a>
                    <a href="<c:url value="/board2/write"/>" class="write">글쓰기</a>
                </div>
                <!-- footer 끝 -->
     </footer>
</header>