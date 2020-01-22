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
               
                <div class="board_list">
                	<c:forEach items="${list }" var="item">
                		
                    <div class="item">
                        <div class="top_wrap">
                            <a href="#" class="image" style="background-image: url(${item.groupIconUrl});"></a>
                            <a href="#" class="name">${item.groupName}</a>
                            <input type="checkbox" id="feed_more">
                            <label for="feed_more">더 보기</label>
                        </div>
                        <c:if test="${not empty item.groupDetailPhotoUrl1}">
                        	<div class="feed_img_slider">
	                            <div class="feed_img">
	                           	 	<c:if test="${not empty item.groupDetailPhotoUrl1}">
	                                	<div class="item" style="background-image:url(<c:url value="${item.groupDetailPhotoUrl1}"/>);">사진</div>
	                            	</c:if>
	                               <c:if test="${not empty item.groupDetailPhotoUrl2}">
	                                	<div class="item" style="background-image:url(<c:url value="${item.groupDetailPhotoUrl2}"/>);">사진</div>
	                            	</c:if>
	                            	<c:if test="${not empty item.groupDetailPhotoUrl3}">
	                                	<div class="item" style="background-image:url(<c:url value="${item.groupDetailPhotoUrl3}"/>);">사진</div>
	                            	</c:if>
	                            </div>
	                        </div>
                        </c:if>
                        <div class="control_wrap">
                            <input type="button" value="좋아요" class="bt_scrap">
                            <input type="button" value="관리" class="bt_share">
                                    
                        </div>    
                        <div class="text_wrap">
                            <div class="text">
                                <p>${item.groupText}</p>
                                <br>
                                <a class="more" href="<c:url value="/list?groupId=${item.id}"/>">채널 참여하기</a>
                                
                            </div>
                            
                        </div>
                    </div>
                    </c:forEach>
                    
                    
                </div>
                <!-- container 끝 -->
            </div>
        </div>
        <div id="footerWrap">
            <footer><c:import url="/inc/footer"></c:import></footer>
        </div>
    </div>
</body>
</html>