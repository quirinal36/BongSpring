<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/member.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/table.css" />
	<script src="<c:url value="/resources/js/sweetalert2.all.min.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	function updateUser(select, id){
		var selectedVal = $(select).val();
		console.log("selectedVal: " + selectedVal);
		console.log("id: " + id);
		
		swal({
			title:"권한변경",
			text :"권한을 변경하시겠습니까?",
			type : "question",
			confirmButtonText : "확인",
			showCancelButton : true,
			cancelButtonText : "취소"
		}).then(function(isYes){
			if(isYes.value){
				$.ajax({
					url : "/admin/update",
					data : {user_role : selectedVal, id: id},
					type : "GET"
				}).done(function(resp){
					alert("수정성공\n" + resp);
					window.location.reload();
				});
			}
		})
	}
	</script>
</head>
<body>
	<div class="wrap">
	<header><c:import url="/inc/header"></c:import></header>
	<div class="container_wrap">
	<div class="container">
	<table border="1">
		<colgroup>
			<col width="15%">
			<col width="35%">
			<col width="35%">
			<col width="15%">
		</colgroup>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>phone</th>
				<th>권한</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="one_user">
				<tr>
					<td>${one_user.id }</td>
					<td>${one_user.username }</td>
					<td>${one_user.user_phon }</td>
					<td>
						<select onchange="updateUser(this, ${one_user.id})">
							<option value="1" <c:if test="${one_user.user_role == 1 }">selected</c:if>>관리자</option>
							<option value="2" <c:if test="${one_user.user_role == 2 }">selected</c:if>>일반유저</option>
						</select>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
	</div>
</body>
</html>