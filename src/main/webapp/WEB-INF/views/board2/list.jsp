<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
					<table>
						<thead>
							<tr>
								<td>Board List</td>
								
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list }" var="item">
							<tr>
								<td>${item.id}</td>
								<td>
									<a href="<c:url value="/board2/detail?boardId=${item.id}"/>">
										${item.text}
									</a>
								</td>
								<td>${item.writerName}</td>
								<td>${item.userLevel}</td>
								<td>${item.updatedTime}</td>
								<td>${item.accessLevel}</td>
							</tr>
							
						</c:forEach>
							<tr>
								<td><a href="<c:url value="/board2/write"/>">
										쓰기
									</a>
								</td>
							</tr>
						</tbody>
					</table></body>
</html>