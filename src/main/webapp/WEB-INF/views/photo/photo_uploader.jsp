<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy, java.util.*, java.io.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="today" class="java.util.Date"/>
<fmt:formatDate value="${today}" pattern="yyyyMMddhhmm" var="nowDate" scope="application"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/photo_uploader.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
<script src="<c:url value="/resources/js/sweetalert2.all.min.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	var kb = 1024;
	var mb = 1024 * kb;
	var maxFileSize = 10 * mb;
	
	function fn_imageUp() {
		document.editor_upimage.submit();
	}
	
	function fn_imageUp5() {
		// console.log("fn_imageUp5() ");
		document.editor_upimage5.submit();
	}
	
	$(function(){
		$("#uploadInputBox").on('change', function(e){
			var length = this.files.length;
			
			for(var i=0; i<length; i++){
				var dd = $("#file_infos_temp dd").clone();
				
				var file = this.files[i];
				
				if(file.size > maxFileSize){
					toast({
						'text':'용량초과'
					});
				}else{
					var reader  = new FileReader();
					reader.onloadend = function(){
						$(dd).find(".preview").attr("src", reader.result);	
						console.log("--0");
						console.log($(dd));
					}
					if(file){
						console.log("--1");
						console.log(file);
						reader.readAsDataURL(file);
						// $("#preview").show();
					}
					// console.log(sizeToMB(file.size));
					$(dd).find(".file_name").html(file.name);
					//$("#file_size").html("(" + sizeToMB(file.size) +")");
					
					//$("#file_info").show();
				}
				$("#btn_confirm").attr("src", "<c:url value='/resources/img/photoQuickPopup/btn_confirm2.png'/>");
				dd.appendTo("#file_infos");
			}
			$(this).hide();
		});
	});
	function deleteUpload(){
		$("#uploadInputBox").show();
		$("#preview").hide();
		$("#file_info").hide();
		$("#btn_confirm").attr("src", "<c:url value='/resources/img/photoQuickPopup/btn_confirm.png'/>");
	}
	function sizeToMB(input){
		var kb = Number(parseInt(input) / 1024).toFixed(2);
		var result;
		if(kb < 1000){
			result = kb + "Kb";
		}else{
			result = Number(parseInt(kb)/1024).toFixed(2) + "Mb";
		}
		return result;
	}
</script>
<title>사진첨부하기</title>
</head>
<body>
<div id="pop_wrap">
	<!-- header -->
    <div id="pop_header">
        <h1>사진 첨부하기</h1>
    </div>
    <!-- //header -->
    <!-- container -->
	
    <!-- [D] HTML5인 경우 pop_container 클래스와 하위 HTML 적용
	    	 그밖의 경우 pop_container2 클래스와 하위 HTML 적용      -->
	<div id="pop_container2" class="pop_container2">
		<form id="editor_upimage" name="editor_upimage" action="<c:url value="/file_uploader"/>" method="post" enctype="multipart/form-data" onSubmit="return false;">
	        <div id="pop_content2">
				<input type="file" class="upload" id="uploadInputBox" name="Filedata"
					accept="image/x-png, image/gif, image/jpeg, image/bmp" multiple>
				<input type="hidden" value="${target}" name="target"/>
				<dl id="file_infos"></dl>
				<dl id="file_infos_temp" style="display:none;">
					<dd>
						<span class="file_name"></span>
						<span class="file_size"></span>
						<a href="javascript:deleteUpload();">
							<img src="<c:url value="/resources/img/photoQuickPopup/btn_del.png"/>" width="16" height="16" alt="삭제">
						</a>
						<img src="" height="200" class="preview" />
					</dd>
				</dl>
	            <p class="dsc" id="info">
	            	<strong>10MB</strong>이하의 이미지 파일만 등록할 수 있습니다.<br>(JPG, GIF, PNG, BMP)
	            </p>
	        </div>
		</form>
		
		<div id="pop_footer">
		    <div class="btn_area">
	            <a href="javascript:fn_imageUp();"><img src="<c:url value="/resources/img/photoQuickPopup/btn_confirm.png"/>" width="49" height="28" alt="확인" id="btn_confirm"></a>
	            <a href="javascript:window.close();"><img src="<c:url value="/resources/img/photoQuickPopup/btn_cancel.png"/>" width="48" height="28" alt="취소" id="btn_cancel"></a>
	        </div>
    	</div>
    </div>
</div>