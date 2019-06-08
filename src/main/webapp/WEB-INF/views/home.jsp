<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
<meta charset="UTF-8">
</head>
<body>
	<div class="wrap">
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<div class="container_wrap">
			<div class="container">
			${user}
			</div>
		</div>
		<footer>
			<p>ⓒ 회사명.</p>
		</footer>
	</div>
</body>
</html>