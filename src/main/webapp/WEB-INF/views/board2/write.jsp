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
<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/css/table.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.ui.widget.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.iframe-transport.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.fileupload.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script>
$(document).ready(function(){
    $(function() {
   $('#submit1').click(function(e) {
        e.preventDefault();
        $("#writeboard").submit();
        console.log("submit");
    });

   $('#submit2').click(function(e) {
        e.preventDefault();
        $("#writeboard").submit();
    });
});
});
</script>

</head>
<body>
	<div class="wrap">
		<c:import url="/inc/header"></c:import>
		<div class="container_wrap">
			<div class="container">
				<form id="writeboard" action="/board2/insert" method="post" >
					<table>
						<colgroup>
							<col width="30%">
							<col width="70%">
						</colgroup>
						<thead>
							<tr>
								<th colspan="2">
									글쓰기								
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>글쓴이Id</td>
								<td><input type="text" name="creatorId" placeholder="글쓴이Id" required/></td>
							</tr>
							<tr>
								<td>환자번호</td>
								<td><input type="text" name="patientId" placeholder="환자번호" required/></td>
							</tr>
							<tr>
								<td>status</td>
								<td><input type="text" name="status" placeholder="글상태" required/></td>
							</tr>
							<tr>
								<td>text</td>
								<td><input type="text" name="text" placeholder="내용"/></td>
							</tr>
							<tr>
								<td>type</td>
								<td><input type="text" name="type" placeholder="종류"/></td>
							</tr>
							<tr>
								<td>accessLevel</td>
								<td><input type="text" name="accessLevel" placeholder="열람등급"/></td>
							</tr>
							
							
						</tbody>
					</table>
					
						<input type="submit" name="submitme" value="Submit1" id="submit1" />
 					   <p><a href="#" id="submit2">Submit</a></p>
    				</form>
	</div>
	</div>
	</div>
	

</body>
</html>