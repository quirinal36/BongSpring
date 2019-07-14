<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>사진올리기</title>
	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
	<link href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css" rel="stylesheet" />
	<link href="<c:url value="/resources/css/dropzone.css"/>" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/css/table.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#searchPatientInfo").on('click', function(){
			var url = $("input[name='searchPatientInfoUrl']").val();
			var id = $("input[name='patientId']").val();
			
			$.ajax({
				url : url+"/"+id,
				type: "GET"
			}).done(function(resp){
				for(var i=0;i<resp.length; i++){
					var patientInfo = resp[i];
					//$("#searchList").append($("<dd>").html(patientInfo.name));
					$("input[name='name']").val(patientInfo.name);
					$("input[name='doctor']").val(patientInfo.doctor);
					$("#write").find("input[name='id']").val(patientInfo.id);
				}
			});
		});
	});
	</script>
	<style type="text/css">
	.list {
        height: expression( this.scrollHeight > 99 ? "100px" : "auto" );
        max-height: 100px;
        border: 1px solid #666;
        overflow-y: auto;
	}
	</style>
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
									환자정보 찾기 / 입력							
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>등록번호</td>
								<td>
									<input type="text" name="patientId" placeholder="등록번호" required/>
									<input type="hidden" name="id"/>
									<input type="hidden" name="searchPatientInfoUrl" value="<c:url value="/search/patientInfo/"/>" />
									<input type="button" value="검색" id="searchPatientInfo"/>
									
								</td>
							</tr>
							<tr>
								<td>환자명</td>
								<td><input type="text" name="name" placeholder="환자명" required/></td>
							</tr>
							<tr>
								<td>주치의</td>
								<td>
								<select name="doctor">
									<option>--선택--</option>
									<option value="봉황세">봉황세</option>
									<option value="홍길동">홍길동</option>
									<option value="이병호">이병호</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>등록담당자</td>
								<td><input type="text" name="uploader" placeholder="등록담당자" value="${user.username }" required/></td>
							</tr>
							<tr>
								<td>분류</td>
								<td>
								<select name="classification">
									<option>--선택--</option>
									<option value="수술중" selected>수술중</option>
									<option value="응급실">응급실</option>
									
								</select>
								</td>
							</tr>
							<tr>
								<td>촬영일</td>
								<td><input type="text" name="date" placeholder="촬영일" value="${today }"/></td>
							</tr>
							
							
						</tbody>
					</table>
					<input id="fileupload" type="file" name="files[]" 
						accept="image/x-png,image/gif,image/jpeg" data-url="<c:url value="/upload"/>" multiple>
				    </form>
				    <div id="progress">
				        <div style="width: 0%;"></div>
				    </div>
				    <table id="uploaded-files">
				    	<colgroup>
				    		<col width="20%">
				    		<col width="20%">
				    		<col width="20%">
				    		<col width="20%">
				    		<col width="20%">
				    	</colgroup>
				    	<thead>
				    		<tr>
								<th colspan="5">사진업로드</th>
							</tr>
						</thead>
						<tbody>
					        <tr>
					        	<th>미리보기</th>
					            <th>파일명</th>
					            <th>Size</th>
					            <th>코멘트</th>
					            <th></th>
					        </tr>
				        </tbody>
				    </table>
					<input type="hidden" value="<c:url value="/upload/get"/>" name="uploadUrl">
					<input type="button" value="글작성" onclick="javascript:insertPhoto();">
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function () {
		$(window).bind("beforeunload", function(){
			var patientId = $("#write").find("input[name='patientId']").val();
			console.log("patientId: " + patientId);
			
			if(patientId != 'undefined' && patientId.length > 0){
				return "작성중인 정보가 사라집니다. 창을 나가시겠습니까?";
			}
		});
		
	    $('#fileupload')
	    	.fileupload({
		        dataType: 'json',
		        disableImageResize: /Android(?!.*Chrome)|Opera/
		            .test(window.navigator && navigator.userAgent),
		        imageMaxWidth: 100,
		        imageMaxHeight: 100,
		        previewCrop : true
	    	}).on('fileuploadsubmit', function(e, data){
	    		var param = new Object();
	    		$("#write input").each(function(i, item){
	    			param[$(item).attr('name')] = $(item).val();
	    		});
	    		param['classification'] = $("select[name='classification']").val();
	    		param['doctor'] = $("select[name='doctor']").val();
	    		param['uploader'] = $("select[name='uploader']").val();

	    		console.log(param);
				data.formData = param;   		
	    	}).on('progressall', function (e, data) {
	            var progress = parseInt(data.loaded / data.total * 100, 10);
	            console.log("progress: " + progress);
	            $('#progress .bar').css(
	                'width',
	                progress + '%'
	            );
	        }).on('fileuploaddone', function (e, data) {
	        	console.log(data.result);
	            $.each(data.result.files, function (index, file) {
	            	console.log("index: " + index);
	            	$("#uploaded-files").append(
	                        $('<tr/>')
	                        .append($('<td/>').append($('<img/>').attr('src', file.url)))
	                        .append($('<td/>').text(file.name))
	                        .append($('<td/>').text(file.size))
	                        .append(
	                        		$('<td/>')
	                        		.append($("<input/>").attr('name', 'comment').attr('type','text'))
	                        		.append($("<input/>").attr('name', 'id').attr('type','hidden').val(file.id))
	                        		)
	                        .append($('<td/>').html(
	                        		"<input type='button' value='삭제' onclick='deleteThis("+file.id+")'/>"
	                        		))
	                        		.attr("id", file.id)
	                        )//end 
	                $("#uploaded-files").append()
	                if (file.url) {
	                    var link = $('<a>')
	                        .attr('target', '_blank')
	                        .prop('href', file.url);
	                    
	                    console.log(link);
	                    
	                } else if (file.error) {
	                    var error = $('<span class="text-danger"/>').text(file.error);
	                    $(data.context.children()[index])
	                        .append('<br>')
	                        .append(error);
	                }
	            });
	        }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
	    
	});
	function insertPhoto(){
		var patientInfo = $("#write").serializeArray();
		var patientInfo2 = $("#write").serialize();
		
		//var arr = [];
		
		$("#uploaded-files > tbody").find("tr").each(function(){
			var comment = $(this).find("input[name='comment']").val();
			var id = $(this).find("input[name='id']").val();
			
			var photo = {
				"id" : id,
				"comment" : comment
			};
			var info = {'name':'photo', 'value':JSON.stringify(photo)};
			if(parseInt(id) > 0){
				//arr.push(photo);
				patientInfo.push( info );
			}
		});
		
		//console.log(arr);
		//patientInfo.push(arr);
		console.log(patientInfo);
		var url = "/photoInfo/save";
		$.ajax({
			url : url,
			data: patientInfo
		}).done(function(resp){
			console.log(resp);
		});
	}
	function deleteThis(id){
		$.ajax({
			url : "/delete/"+id,
			type: "DELETE"
		}).done(function(resp){
			$("#"+id).remove();
		});
	}
	</script>
	
	<script src="<c:url value="/resources/js/jquery.ui.widget.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.iframe-transport.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.fileupload.js"/>"></script>
	<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
	<script src="https://blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script> 
	<!-- The File Upload processing plugin -->
	<script src="<c:url value="/resources/js/jquery.fileupload-process.js"/>"></script>
	<!-- The File Upload image preview & resize plugin -->
	<script src="<c:url value="/resources/js/jquery.fileupload-image.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>