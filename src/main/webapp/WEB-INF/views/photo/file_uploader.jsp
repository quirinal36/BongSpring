<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<c:choose>
	<c:when test="${above_permission eq true}">
		<script>alert("업로드 용량(총 20Mytes)을 초과하였습니다.");history.back();</script>
	</c:when>
	<c:otherwise>
		<form id="fileform" name="fileform" method="post">
			<input type="hidden" name="filename" 	value="${filename}">
			<input type="hidden" name="url" 		value="${uploaded_url}">
		</form>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	function fileAttach(){ 
		var f = document.fileform;
	    var fname 	= f.filename.value; 
	    //var target  = f.target.value;
	    var uploaded_url = f.url.value;
	    //var formData = $("#fileform").serialize();
	    console.log("fname: " + fname);
	    console.log("uploaded_url : " + uploaded_url);
	    
	    try{
	    	window.opener.$("#targetImgPreview").css({
	    		'background' : 'url("' + uploaded_url +'") 50% 50%',
    			'background-size' : 'contain',
    			'background-position' : '50% 50%',
    			'background-repeat' : 'no-repeat'
	    		});
	    	window.opener.$("#targetUpload").val(uploaded_url);
	    }catch(e){ 
           alert(e); 
	    }
	}
	fileAttach();
	this.window.close();
</script>
