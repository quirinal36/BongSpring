<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/css.css"/>" />
	<script src="<c:url value="/resources/js/jquery-1.12.1.min.js"/>"></script>
</head>
<body>
    <div id="wrap">
        <div class="member_wrap">
            <div>
                <h2>
                <span>계정</span>을<br>
                로그인하세요.
                </h2>
                <form class="form1" action="<c:url value="/j_spring_security_check"/>" method="post">
                    <dl>
                        <dt>아이디</dt>
                        <dd><input type="text" name="loginid" value="${loginid }" placeholder="아이디" required></dd>
                    </dl>
                    <dl class="pass">
                        <dt>비밀번호
                            <a href="#">비밀번호를 잊으셨나요?</a>
                        </dt> 
                        <dd><input type="password" name="loginpwd" value="${loginpwd }" placeholder="*******" required></dd>
                    </dl>
                    <c:if test="${not empty securityexceptionmsg }">
						<span id="error_msg" class="error" >${securityexceptionmsg}</span>
					</c:if>
					<input type="hidden" name="loginRedirect" value="${loginRedirect }"/>
                    <div>
                        <input type="checkbox" id="save_info">
                        <label for="save_info"><span>계정 정보를 저장합니다.</span></label>
                    </div>
                    <input type="submit" value="로그인" class="bt_login">        
                </form>
                <a href="#" class="bt_kakao">카카오톡으로로그인</a>   
            </div>
        </div>
    </div>
   <%--  <div id="wrap" style="display:none;">
        <div id="headerWrap">
        <!-- header 분리함  -->
           <%@ include file="/WEB-INF/views/inc/header_app.jsp" %>
        </div>
        <div id="containerWrap">
            <div id="container">
                <!-- container 시작 -->

		<!-- 컨텐츠 시작 -->
		<div id="login" class="member">
			<form class="form2" action="<c:url value="/j_spring_security_check"/>" method="post">
				<dl>
					<dd><input type="text" name="loginid" value="${loginid }" required placeholder="아이디를 입력하세요."/></dd>
				</dl>
				<dl>
					<dd><input type="password" name="loginpwd" 	placeholder="비밀번호를 입력하세요." required 
								value="${loginpwd }"/></dd>
				</dl>
				<c:if test="${not empty securityexceptionmsg }">
					<span id="error_msg" class="error" >${securityexceptionmsg}</span>
				</c:if>
				<input type="hidden" name="loginRedirect" value="${loginRedirect }"/>
				<input type="submit" value="로그인" class="bt1" />
			</form>
			<a href="<c:url value="/member/find"/>">아이디/비밀번호 찾기</a>
			<a href="<c:url value="/member/join_step2"/>">회원가입</a>
		</div>
		<!-- 컨텐츠 끝 -->
		</div>
	</div> --%>
	<div id="footerWrap">
		<footer>
			<c:import url="/inc/footer"></c:import>
		</footer>
	</div>
</div>
</body>
</html>