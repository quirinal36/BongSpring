<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="su" uri="tlds/customTags.tld"%>

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
                <div class="notice_area">
                    <a href="#" class="title">공 지</a>
                    <a href="#" class="item">${user.role } 테스트 중입니다.</a>
                </div>
                <div class="board_list">
                	<c:forEach items="${list }" var="item">
                		
                    <div class="item">
                        <div class="top_wrap">
                            <a href="#" class="image" style="background-image: url(${item.profileUrl});"></a>
                            <a href="#" class="name">${item.writerName} (${item.position })</a>
                            <span class="time">${su:dateStr(item.updatedTime)}</span>
                            <input type="checkbox" id="feed_more">
                            <label for="feed_more">더 보기</label>
                        </div>
                       
                        <c:if test="${not empty item.photoList}">
                        	
	                        <div class="feed_img_slider">
	                            <div class="feed_img">
									<c:forEach begin="0" end="${item.photoListArray.length() -1}" var="index">
		                                <div class="item" style="background-image:url(/PatientPhoto/thumbnail/${item.photoListArray.getJSONObject(index).getInt("photoId")})";>사진</div>
		                            </c:forEach>  
	                            </div>
	                        </div>
                        </c:if>
                        
                        <div class="control_wrap">
                            <input type="button" value="스크랩" class="bt_scrap">
                            <input type="button" value="공유하기" class="bt_share">
                            <select>
                                <option>공개범위설정</option>
                                <option>전체공재</option>
                                <option>환자공개</option>
                                <option>담당의공개</option>
                            </select>            
                        </div>    
                        <div class="text_wrap">
                            <div class="text">
                                <p>${item.text}</p>
                                <a class="more" href="<c:url value="/board2/detail?boardId=${item.id }"/>">더 보기</a>
                            </div>
                            <div class="comment">
                                <a class="more" href="#">댓글 ${item.replyCount}개</a> 
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