<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css" >
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/board.css"/>" />
	<script src="<c:url value="/resources/js/board.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
	</head>
	<body>
		<div class="wrap">
		<c:import url="/inc/header"></c:import>
			<div class="container_wrap">
				<div class="container">
					<form action="<c:url value="/oprecord/list"/>">
						<input type="text" placeholder="작성자/제목 검색" name="search" value="${board.search }"/>
						<input type="submit" value="검색"/>
						<sec:authorize access="isAuthenticated()">
							<input type="button" value="새글작성" onclick="javascript:window.location.href='<c:url value='/board/write'/>'"/>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							글을 작성하시려면 로그인해주세요
						</sec:authorize>
						<input type="button" value="정렬" onclick="javascript:orderSubmit('${board.orderById}');"/>
						<input type="hidden" value="${board.orderById }" name="orderById"/>
						<input type="hidden" value="${board.pageNo }" name="page"/>
						<span style="float:right;">총<c:out value="${board.totalCount }"/>개의 게시글</span>
					</form>
					<table>
						<colgroup>
							<col width="10%">
							<col width="90%">
						</colgroup>
						<thead>
							<tr>
								<th>num</th>
								<th>procedure</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="item" varStatus="sts">
								<tr>
									<td>${sts.count }</td>
									<td>${item.procedure }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>