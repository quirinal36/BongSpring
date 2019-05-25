<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>사진올리기</title>
	
	<link href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css" rel="stylesheet" />
	<link href="<c:url value="/resources/css/dropzone.css"/>" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/css/table.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
	<script type="text/javascript">
	$(document).ready(function(){
		
		var url = $("#clearUrl").val();
		console.log(url);
		
		$.ajax({
			url : url,
			type : "GET"
		}).done(function(resp){
			alert("clear ok~!");
		});
	});
	</script>
</head>
<body>
	<div class="wrap">
		<c:import url="/inc/header"></c:import>
		<div class="container_wrap">
			<div class="container">
				<form id="write" action="<c:url value="/photoInfo/insert"/>" method="post">
					<table>
						<colgroup>
							<col width="30%">
							<col width="70%">
						</colgroup>
						<thead>
							<tr>
								<th colspan="2">
									사진정보 업로드								
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>등록번호</td>
								<td><input type="text" name="regNo" placeholder="등록번호" required/></td>
							</tr>
							<tr>
								<td>환자이름</td>
								<td><input type="text" name="patientName" placeholder="환자이름" required/></td>
							</tr>
							<tr>
								<td>등록담당자</td>
								<td><input type="text" name="uploader" placeholder="등록담당자" value="${user.username }" required/></td>
							</tr>
							<tr>
								<td>분류</td>
								<td><input type="text" name="specification" placeholder="분류"/></td>
							</tr>
							<tr>
								<td>찍은날짜</td>
								<td><input type="text" name="issuedAt" placeholder="찍은날짜" value="${today }"/></td>
							</tr>
							
						</tbody>
					</table>
					<input id="fileupload" type="file" name="files[]" 
						accept="image/x-png,image/gif,image/jpeg" data-url="<c:url value="/upload"/>" multiple>
				    <div id="progress">
				        <div style="width: 0%;"></div>
				    </div>
				    <table id="uploaded-files">
				    	<thead>
				    		<tr>
								<th colspan="3">사진업로드</th>
							</tr>
						</thead>
						<tbody>
					        <tr>
					            <th>파일명</th>
					            <th>Size</th>
					            <th>Type</th>
					        </tr>
				        </tbody>
				    </table>
					<input type="hidden" value="<c:url value="/upload/get"/>" name="uploadUrl">
					<input type="hidden" value="<c:url value="/upload/clear"/>" name="clearUrl">
					<input type="button" value="글작성" onclick="javascript:insertBoard();">
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function () {
	    $('#fileupload').fileupload({
	    	imageCrop: true,
	        dataType: 'json',
	        done: function (e, data) {
	        	var url = $("input[name='uploadUrl']").val();
	            $("#uploaded-files tr:has(td)").remove();
	            $.each(data.result, function (index, file) {
	                $("#uploaded-files").append(
	                        $('<tr/>')
	                        .append($('<td/>').text(file.fileName))
	                        .append($('<td/>').text(file.fileSize))
	                        .append($('<td/>').text(file.fileType))
	                        )//end $("#uploaded-files").append()
	            }); 
	        },
	 		
	        progressall: function (e, data) {
	            var progress = parseInt(data.loaded / data.total * 100, 10);
	            $('#progress .bar').css(
	                'width',
	                progress + '%'
	            );
	        },
	 
	        dropZone: $('#dropzone')
	    });
	});
	function insertBoard(){
		$("#write").submit();
	}
	</script>
	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.ui.widget.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.iframe-transport.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.fileupload.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>