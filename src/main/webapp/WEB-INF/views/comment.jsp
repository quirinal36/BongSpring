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
        <div id="containerWrap">
            <div id="container">
                <!-- container 시작 -->
                <div class="comment_list_wrap">
                    <!--이전페이지-->
                    <div class="last_page">
                        <a href="history.back();">이전페이지</a>
                    </div>
                    <!--댓글리스트-->
                    <div class="comment_list">
                        <div class="item patient">
                            <div class="cont">
                                <a href="#">홍길동 (001234123) </a>
                                <p>발목염좌 왜이렇게 자주 생기나요<br>
                                꾸준히 치료하고 나름 발목염좌 안생기게 신경도 썼는데 그래도 발목염좌 자주 새역요 그러니까 자주 삐끗하는데, 이거 뭐가 문제일까요 <br>
                                도와주세요 의사선생님
                                </p>
                                <input type="checkbox" id="comment1" class="patient_dot">
                                <label for="comment1">메뉴</label>
                            </div>
                            <span>2시간전</span>
                        </div>
                        <div class="item doctor">
                            <div class="cont">
                                <a href="#">봉황세 전문의</a>
                                <p>발목염좌 왜이렇게 자주 생기나요<br>
                                꾸준히 치료하고 나름 발목염좌 안생기게 신경도 썼는데 그래도 발목염좌 자주 새역요 그러니까 자주 삐끗하는데, 이거 뭐가 문제일까요 <br>
                                도와주세요 의사선생님
                                </p>
                                <div class="images">
                                    <a href="#"><img src="/img/temp/slider1.jpg" alt="사진"></a>
                                    <a href="#"><img src="/img/temp/slider2.jpg" alt="사진"></a>
                                    <a href="#"><img src="/img/temp/slider3.jpg" alt="사진"></a>
                                    <a href="#"><img src="/img/temp/slider1.jpg" alt="사진"></a>
                                    <a href="#"><img src="/img/temp/slider2.jpg" alt="사진"></a>
                                    <a href="#"><img src="/img/temp/slider3.jpg" alt="사진"></a>
                                    <a href="#"><img src="/img/temp/slider1.jpg" alt="사진"></a>                             </div>
                                <input type="checkbox" id="comment1" class="patient_dot">
                                <label for="comment1">메뉴</label>
                            </div>
                            <span>2시간전</span>
                        </div>
                        <div class="item nurse">
                            <div class="cont">
                                <a href="#"> 이미송 간호사</a>
                                <p>발목염좌 왜이렇게 자주 생기나요<br>
                                꾸준히 치료하고 나름 발목염좌 안생기게 신경도 썼는데 그래도 발목염좌 자주 새역요 그러니까 자주 삐끗하는데, 이거 뭐가 문제일까요 <br>
                                </p>
                                <input type="checkbox" id="comment1" class="patient_dot">
                                <label for="comment1">메뉴</label>
                            </div>
                        <span>2시간전</span>
                        </div>
                    </div>
                    <!--댓글입력창-->
                    <div class="comment_write">
                        <form>
                            <input type="checkbox" id="img_select">
                            <label for="img_select">사진</label>
                            <div class="comment">
                                <textarea placeholder="댓글을 입력하세요."></textarea>
                                <input type="button" value="입 력">
                            </div>
                        </form>
                    </div>
                    <!-- container 끝 -->
                </div>
            </div>
        </div>
    </div>
</body>
</html>