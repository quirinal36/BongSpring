<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/css/table.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/board.css"/>" />
	<script src="<c:url value="/resources/js/record.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
	</head>
	<body>
		<div class="wrap">
		<c:import url="/inc/header"></c:import>
			<div class="container_wrap">
				<div class="container">
					<form action="<c:url value="/oprecord/list"/>">
						<input type="text" placeholder="진단/수술명/주치의 검색" name="search" value="${record.search }"/>
						<input type="submit" value="검색"/>
						<sec:authorize access="isAuthenticated()">
							<input type="button" value="새글작성" onclick="javascript:window.location.href='<c:url value='/oprecord/write'/>'"/>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							글을 작성하시려면 로그인해주세요
						</sec:authorize>
						<input type="button" value="정렬" onclick="javascript:orderSubmit('');"/>
						<input type="hidden" value="" name="orderById"/>
						<input type="hidden" value="${record.pageNo }" name="pageNum"/>
						<span style="float:right;">총<c:out value="${record.totalCount }"/>개의 게시글</span>
					</form>
					<table>
						<colgroup>
							<col width="2%">
							<col width="8%">
							<col width="10%">
							<col width="30%">
							<col width="30%">
							<col width="20%">
						</colgroup>
						<thead>
							<tr>
								<th>No</th>
								<th>수술일</th>
								<th>환자명</th>
								<th>진단명</th>
								<th>수술명</th>
								<th>집도의</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="item" varStatus="sts">
								<tr>
									<td>${sts.count }</td>
									<td>${item.opdate }</td>
									<td>${item.patientName}</td>
									<td>${item.dx }</td>
									<td>
									<a href="/oprecord/detail/${item.id }">
									${item.opname } </a>
									</td>
									<td>${item.doctor }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="board-list-page">
						<c:forEach begin="1" end="${record.endPageNo }" varStatus="status">
							<a href="javascript:movePage('${status.index }')" class="fc-blue board-list-page-num<c:if test="${record.pageNo == status.index}">-on</c:if>">${status.index}</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>