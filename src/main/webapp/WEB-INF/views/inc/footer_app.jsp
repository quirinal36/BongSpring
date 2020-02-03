<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/resources/css/css.css"/>">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <style>
        #content {
            width:350px;
            height:350px;
            background:#ededed;
            padding:10px;
            margin:30px;
}
    </style>

<script>    
        //$(document.ready(function(){ .. });
        $(function(){
            //$("#dialog").dialog();
            $("#writeDialog").dialog({
                autoOpen:false,  //자동으로 열리지않게
                position:{my:"center",at:"bottom",of:"#content"},
                //"center", "left", "right", "top", "bottom"
 				/* position:["center","bottom"], */
                modal:true, //모달대화상자
                resizable:false, //크기 조절 못하게
                
                buttons:{
                    "확인":function(){
                        $(this).dialog("close");
                        window.location.replace("<c:url value="/board2/write"/>");
                    },"취소":function(){
                        $(this).dialog("close");
                    }
                }
            });

            //창 열기 버튼을 클릭했을경우
            $("#btnWrite").on("click",function(){
                $("#writeDialog").dialog("open"); //다이얼로그창 오픈                
            });
        });
</script>   

<footer>
                <!-- footer 시작 -->
                <div id="fixedMenu">
                    <a href="<c:url value="/list"/>" class="home">홈</a>
                    <a href="#" class="notice">진료안내</a>
                    <a href="<c:url value="/myGroup"/>" class="info">내정보</a>
                    <a href="#" id="btnWrite" class="write">글쓰기</a>
                </div>
                <!-- footer 끝 -->
                
                <div id="writeDialog" title="글쓰기">
				   주치의에게 글쓰기<br>
				   그룹 선택 
				</div>
    
</footer>