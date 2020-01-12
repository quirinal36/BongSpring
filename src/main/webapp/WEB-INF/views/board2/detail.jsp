<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail view</title>
</head>
<body>
					<table>
						<thead>
							<tr>
								<td>Board Detail</td>
								<td>
									<a href="<c:url value="/board2/list" />">
										Home
									</a>
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									${board.id }
								</td>
								<td>
									${board.text }
								</td>
								<td>${board.writerName}</td>
								<td>${board.userLevel}</td>
								<td>${board.updatedTime}</td>
								<td>${board.accessLevel}</td>
							</tr>
							<tr>
								<td>--reply--</td>
							</tr>
						<c:forEach items="${reply }" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.text}</td>
								<td>${item.writerId}</td>
								<td>${item.createdTime}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table></body>
</html>