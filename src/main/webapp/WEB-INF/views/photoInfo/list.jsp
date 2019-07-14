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
	<script src="<c:url value="/resources/js/board.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
	<script type="text/javascript">
	function movePage(pageNum){
		$("form").find("input[name='pageNo']").val(pageNum);
		$("form").submit();
	}
	</script>
	</head>
	<body>
		<div class="wrap">
		<c:import url="/inc/header"></c:import>
			<div class="container_wrap">
				<div class="container">
					<form action="<c:url value="/photoInfo/list"/>">
						<input type="text" placeholder="작성자/제목 검색" name="search" value="${info.search }"/>
						<input type="submit" value="검색"/>
						<sec:authorize access="isAuthenticated()">
							<input type="button" value="새글작성" onclick="javascript:window.location.href='<c:url value='/photoInfo/write'/>'"/>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							글을 작성하시려면 로그인해주세요
						</sec:authorize>
						<input type="button" value="정렬" onclick="javascript:orderSubmit('${info.orderById}');"/>
						<input type="hidden" value="${info.orderById }" name="orderById"/>
						<input type="hidden" value="${info.pageNo }" name="pageNo"/>
						<span style="float:right;">총<c:out value="${info.totalCount }"/>개의 게시글</span>
					</form>
					
					<c:set var="textNum" value="번호" scope="page"/>
					<c:set var="textTitle" value="PatientId" scope="page"/>
					<c:set var="textWriter" value="PhotoURL" scope="page"/>
					<c:set var="textDate" value="date" scope="page"/>
					<table>
						<thead>
							<tr>
								<th><c:out value="${textNum }"/></th>
								<th><c:out value="${textTitle }"/></th>
								<th><c:out value="${textWriter }"/></th>
								<th><c:out value="${textDate }"/></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list }" var="item">
							<tr>
								<td>
									<a href="<c:url value="/photoInfo/detail?id=${item.id}"/>">
										${item.id}
									</a>
								</td>
								<td>
									<a href="<c:url value="/patient/detail?patientId=${item.patientId }"/>">
										${item.patientId}
									</a>
								</td>
								<td>${item.photoUrl}</td>
								<td>${item.date}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
					<div class="board-list-page">
						<c:forEach begin="1" end="${info.endPageNo }" varStatus="status">
							<a href="javascript:movePage('${status.index }')" class="fc-blue board-list-page-num<c:if test="${info.pageNo == status.index}">-on</c:if>">${status.index}</a>
						</c:forEach>
					</div>

				</div>
			</div>
			<footer>
				<p>ⓒ 회사명.</p>
			</footer>
		</div>
		
	</body>
</html>