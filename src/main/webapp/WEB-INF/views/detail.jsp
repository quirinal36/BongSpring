<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>어디아포</title>
    <link rel="stylesheet" href="/css/css.css">
    <script src="/js/jquery-1.12.1.min.js"></script>
    <script src="/js/jquery.bxslider.js"></script>
    <script src="/js/index.js"></script>
    <script src="/js/common.js"></script>
</head>
<body>
    <div id="wrap">
        <div id="headerWrap">
            <header>
                <!-- header 시작 -->
                <h1>
                    <a href="/"><img src="/sources/img/comm/logo.png" alt="마이닥터"></a>
                </h1>
                <div class="right">
                    <a href="#">로그인</a>
                    <a href="#">회원가입</a>
                    <input type="checkbox" id="bt_gnb">
                    <label for="bt_gnb">메뉴</label>
                </div>
                <!-- header 끝 -->
            </header>
        </div>
        <div id="containerWrap">
            <div id="container">
                <!-- container 시작 -->
                <div class="board_list detail">
                    <div class="back">
                        <a href="history.back();">이전페이지</a>
                    </div>    
                    <div class="item">                    
                        <div class="top_wrap">
                            <a href="#" class="image" style="background-image: url(/sources/img/temp/1.jpg);">홍길동</a>
                            <a href="#" class="name">홍길동 정형외과 전문의</a>
                            <span class="time">2시간 전</span>
                            <input type="checkbox" id="feed_more">
                            <label for="feed_more">더 보기</label>
                        </div>                       
                        <div class="text_wrap">
                            <div class="text">
                                <p>앞십자인대와 뒤십자인대가 있으며 무릎관절 내에 존재하나 인대는 활막에 싸여 구별되므로 십자인대 자체는 활막 외 조직 이다.
                                    <br>인대파열 정도가 심하지 않은 경우라면 약물이나 주사 그리고 도수물리 운동 등의 보존적인 처치로 증상 개선을 도와드릴 수 있습니다. 
                                    <br>답변에 도움이 되셨길 바랍니다
                                </p>
                            </div>   
                        </div>    
                        <div class="comment_view">
                            <dl>
                                <dt>
                                    <a href="#" class="profile_image">사진</a>
                                    <a href="#">홍길동환자</a>
                                </dt>
                                <dd class="button">보존치료만 해도 되나요?</dd>
                            </dl>
                            <dl>
                                <dt>
                                    <a href="#" class="profile_image">사진</a>
                                    <a href="#" >홍홍길동환자</a>
                                </dt>
                                <dd class="button">보존치료만 해도 되나요?수술이 필요한가요? 보존치료만 해도 되나요?</dd>
                            </dl>
                            <dl>
                                <dt>
                                    <a href="#" class="profile_image">사진</a>
                                    <a href="#">홍홍홍길동환자</a>
                                </dt>
                                <dd class="button">보존치료만 해도 되나요?수술이 필요한가요? 보존치료만 해도 되나요?수술이 필요한가요? 보존치료만 해도 되나요?</dd>
                            </dl>  
                            <div class="replywrite">
                                <form>
                                    <div class="comment">
                                        <textarea placeholder="댓글을 입력하세요."></textarea>
                                        <input type="button" value="입 력">
                                    </div>
                                </form>
                            </div>                         
                        </div>  
                    </div>        
                </div>
                <div class="detail_img_list">
                    <div class="item">
                        <a href="#" class="image" style="background-image:url(/img/temp/slider1.jpg)";>사진</a>
                        <div class="text_detail">
                            <a href="#">앞십자인대와 뒤십자인대가 있으며 무릎관절 내에 존재하나 인대는존재하나 인대는존재하나 인대는존재하나 인대는존재하나 인대는존재하나 인대는</a>
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