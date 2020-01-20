<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	  console.log(url+"?"+param);
	  
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
			 window.location.replace("/board2/detail?boardId="+ ${board.id});
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
});

function deleteReply(id){
	   var url = "/board2/deleteReply";
	
		if(confirm("삭제 하시겠습니까?")){
			$.ajax({
				url : url,
				data: {'id': id},
				type: "POST", // 비교용 : "POST",
				dataType: "json"
			}).done(function(json){
				console.log("done:"+ json);	// 작성 완료
				window.location.replace("/board2/detail?boardId=" + '${board.id}');
			}).fail(function(){
				console.log("fail");
			});
			//window.location.replace(url + "?id=" + id);
		}
	}
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
                    <div class="item">
                        <div class="top_wrap">
                            <div class="top_wrap">
                                <a href="#" class="image" style="background-image: url(${board.profileUrl});">photo</a>
                                <a href="#" class="name">${board.writerName} (${board.position})</a>
                                <span class="time">${board.updatedTime}</span>
                                <input type="checkbox" id="feed_more">
                                <label for="feed_more">더 보기</label>
                        </div>
                        <div class="text_wrap">
                            <div class="text">
                                <p>${board.text}
                                </p>
                            </div>   
                        </div>     
                        <div class="comment_view">
                        	<c:forEach items="${reply }" var="item">
	                            <dl>
	                                <dt><a href="#">${item.writerName }</a></dt>
	                                <dd>${item.text } (${item.updatedTime }) <input type="button" value="삭제" onclick="javascript:deleteReply('${item.id}')"/></dd>
								
	                            </dl>
                            </c:forEach>
                        </div>  
                        <div class="comment_write">
			                <form id="replyForm" action="/board2/insertReply">
								<table>
									<colgroup>
										<col width="10%">
										<col width="70%">
										<col width="20%">
									</colgroup>
									<thead>
										<tr>
											<th colspan="1">
												답글쓰기								
											</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>${user.username} : </td>
											<td><input type="text" name="text" placeholder="내용" required/></td>
											<td><input type="button" value="답글쓰기" id="replyBtn"/></td>
										</tr>
									</tbody>
								</table>
											<input type="hidden" value="1" name="status"/>
											<input type="hidden" value="${user.id}" name="writerId"/>
											<input type="hidden" value="${board.id }" name="boardId"/>
			   				</form>
                        </div>  
                    </div>    
                </div>
                
                <div class="detail_img_list">
                    <div class="item">
                        <a href="#" class="image" style="background-image:url(/resources/img/temp/slider1.jpg)";>사진</a>
                        <div class="count">
                            <a href="#">댓글 5개</a>
                            <span>공유 3개</span>
                        </div>
                        <div class="bt">
                            <a href="#">댓글작성</a>
                            <a href="javascript:void(0);">공유하기</a>
                        </div>
                    </div> 
                    <div class="item">
                        <a href="#" class="image" style="background-image:url(/resources/img/temp/slider1.jpg)";>사진</a>
                        <div class="count">
                            <a href="#">댓글 5개</a>
                            <span>공유 3개</span>
                        </div>
                        <div class="bt">
                            <a href="#">댓글작성</a>
                            <a href="javascript:void(0);">공유하기</a>
                        </div>
                    </div>   
                    <div class="item">
                        <a href="#" class="image" style="background-image:url(/resources/img/temp/slider1.jpg)";>사진</a>
                        <div class="count">
                            <a href="#">댓글 5개</a>
                            <span>공유 3개</span>
                        </div>
                        <div class="bt">
                            <a href="#">댓글작성</a>
                            <a href="javascript:void(0);">공유하기</a>
                        </div>
                    </div>                      
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