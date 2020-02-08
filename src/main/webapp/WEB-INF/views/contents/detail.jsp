<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>어디아포</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/css.css"/>">
    <script src="<c:url value="/resources/js/jquery-1.12.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.bxslider.js"/>"></script>
    <script src="<c:url value="/resources/js/index.js"/>"></script>
    <script src="<c:url value="/resources/js/common.js"/>"></script>
    <script>
$(document).ready(function(){
   $("#replyBtn").on("click", function(){
	  var param = $("#replyForm").serialize();	// 넘길 정보
	  var url = $("#replyForm").attr("action");	// 처리할 URL
	  
	  /*
	  * AJAX 문법으로 처리
	  */
	  $.ajax({
		  url : url,
		  data: param,
		  type: "POST",
		  dataType: "json"
	  }).done(function(json){
		 console.log(json);	// 작성 완료
		 
		 if(json.id > 1){ // 글작성 성공
			 window.location.replace("<c:url value="/board2/detail?boardId="/>"+ ${board.id});
		 }
	  });
   });
   $("#deleteBtn").on("click", function(){
	   var data = $("#deleteForm").serialize();
	   var url = $("#deleteForm").attr("action");
	   console.log(url +"?" + data);
	   
	   if(confirm("삭제하시겠습니까?")){
			/*
			* AJAX 문법으로 처리
			*/
			$.ajax({
				url : url,
				data: data,
				type: "POST", // 비교용 : "POST",
				dataType: "json"
			}).done(function(json){
				console.log("done:"+ json);	// 작성 완료
				window.location.replace("/board2");
			}).fail(function(){
				console.log("fail");
			});
			
			/*
			AJAX 없이 하려면
			*/
		//	window.location.replace(url + "?" + data);
	   }
	});
   
   /* 사용중지 */
   $("#replyDeleteBtn").on("click", function(){
	   var data = $("#deleteForm").serialize();
	   var url = $("#deleteForm").attr("action");
	   console.log(url +"?" + data);
	   
	   if(confirm("삭제하시겠습니까?")){
			/*
			* AJAX 문법으로 처리
			*/
			$.ajax({
				url : url,
				data: data,
				type: "POST", // 비교용 : "POST",
				dataType: "json"
			}).done(function(json){
				console.log("done:"+ json);	// 작성 완료
				window.location.replace("/board2");
			}).fail(function(){
				console.log("fail");
			});
			
			/*
			AJAX 없이 하려면
			*/
		//	window.location.replace(url + "?" + data);
	   }
	});
	/* 사용중지 */
	
});

function deleteReply(id){
	   var url = "<c:url value="/board2/deleteReply"/>";
	
		if(confirm("삭제 하시겠습니까?")){
			$.ajax({
				url : url,
				data: {'id': id},
				type: "POST", // 비교용 : "POST",
				dataType: "json"
			}).done(function(json){
				console.log("done:"+ json);	// 작성 완료
				window.location.replace("<c:url value="/board2/detail?boardId="/>" + '${board.id}');
			}).fail(function(){
				console.log("fail");
			});
			//window.location.replace(url + "?id=" + id);
		}
	}
	
Date.prototype.format = function(f) {
	if (!this.valueOf()) return " ";

	var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
	var d = this;
	
	return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
		switch ($1) {
			case "yyyy": return d.getFullYear();
			case "yy": return (d.getFullYear() % 1000).zf(2);
			case "MM": return (d.getMonth() + 1).zf(2);
			case "dd": return d.getDate().zf(2);
			case "E": return weekName[d.getDay()];
			case "HH": return d.getHours().zf(2);
			case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
			case "mm": return d.getMinutes().zf(2);
			case "ss": return d.getSeconds().zf(2);
			case "a/p": return d.getHours() < 12 ? "오전" : "오후";
			default: return $1;
		}
	});
};
String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};
</script>
</head>
<body>
    <div id="wrap">
        <div id="headerWrap">
           <!-- header 분리함  -->
			<header><c:import url="/inc/header"></c:import></header>
        </div>
        <div id="containerWrap">
            <div id="container">
                <!-- container 시작 -->
                <div class="board_list detail">
                    <div class="back">
                        <a href="<c:url value="/board2/list"/>">이전페이지</a>
                    </div>    
                    <div class="item">                    
                        <div class="top_wrap">
                            <a href="#" class="image" style="background-image: url(${board.profileUrl});">홍길동</a>
                            <a href="#" class="name">${board.writerName}</a>
                            <span class="time">${board.updatedTime}</span>
                            <input type="checkbox" id="feed_more">
                            <label for="feed_more">더 보기</label>
                        </div>                       
                        <div class="text_wrap">
                            <div class="text">
                                <p>
                                	${board.text }
                                </p>
                            </div>   
                        </div>    
                        <div class="comment_view">
	                        <c:forEach items="${reply }" var="item">
								<dl>
									<dt>
										<a href="#" class="profile_image" style="background-image: url(${item.profileUrl});">사진</a>
										<a href="#">${item.writerName}</a>
									</dt>
									<dd class="button">
										${item.text} / ${item.createdTime}
										<c:if test="${user.id == item.writerId || user.userLevel > '3'}"> 
											<input type="button" value="삭제" onclick="javascript:deleteReply('${item.id}')"/>
										</c:if>
									</dd>
								</dl>
							</c:forEach>
                           
                            <div class="replywrite">
								<form id="replyForm" action="<c:url value="/board2/insertReply"/>">
                                    <div class="comment">
                                    <c:choose>
                                    <c:when test="${user.userLevel > '1'}">
                                        <textarea name="text" placeholder="댓글을 입력하세요."></textarea>
                                        <input type="button" value="답글쓰기" id="replyBtn"/>
                                    </c:when>
                                    <c:otherwise>
                                    	<textarea name="text" placeholder="로그인이 필요합니다!!" disabled></textarea>
                                        <input type="button" value="답글쓰기" id="replyBtn" disabled/>
                                    </c:otherwise>
                                    </c:choose>
                                        <input type="hidden" value="1" name="status">
                                        <input type="hidden" value="${user.id}" name="writerId"/>
                                        <input type="hidden" value="${board.id }" name="boardId">
										
                                    </div>
                                </form>
                            </div>                         
                        </div>  
                    </div>        
                </div>
                
                <div class="detail_img_list">
                	<!-- <script>
                    var testStr = '${board.photoList}';
                    var photoListJson = $.parseJSON(testStr);
                    var jsonStr = photoListJson[0].photoId;
                    </script> -->
                    <c:if test="${not empty board.photoList}">
						<c:forEach begin="0" end="${board.photoListArray.length() -1}" var="index">
		                    <div class="item">
		                        <a href="#" class="image" style="background-image:url(/PatientPhoto/thumbnail/${board.photoListArray.getJSONObject(index).getInt("photoId")})";>사진</a>
		                        <div class="text_detail">
		                            <a href="#"> ${board.photoListArray.getJSONObject(index).getString("caption")}</a>
		                        </div>                    
		                    </div>   
	                    </c:forEach>
                    </c:if>
                     <%-- <%
					    String str = "<script>document.writeln(jsonStr)</script>";
					    out.println(str);
					%> --%>
                </div>
            </div>   
        </div>       
                <!-- container 끝 -->
        <div id="footerWrap">
              <footer><c:import url="/inc/footer"></c:import></footer>
        </div>
    </div>
</body>
</html>