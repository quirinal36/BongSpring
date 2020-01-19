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
                                <a href="#" class="image" style="background-image: url(/resources/img/temp/1.jpg);">홍길동</a>
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
	                                <dd>${item.text }</dd>
	                            </dl>
                            </c:forEach>
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
            <footer>
                <!-- footer 시작 -->
                <div id="fixedMenu">
                    <a href="/" class="home">홈</a>
                    <a href="#" class="notice">진료안내</a>
                    <a href="#" class="info">내 정보</a>
                    <a href="#" class="write">글쓰기</a>
                </div>
                <!-- footer 끝 -->
            </footer>
        </div>
    </div>
</body>
</html>