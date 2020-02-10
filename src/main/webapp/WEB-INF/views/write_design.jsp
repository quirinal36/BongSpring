<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>어디아포</title>
    <link rel="stylesheet" href="/css/css.css">
    <link rel="stylesheet" href="/write/css.css">
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
                    <a href="/"><img src="/img/comm/logo.png" alt="마이닥터"></a>
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
        <div class="write_detail">
            <div class="back">
                <a href="history.back();">이전페이지</a>
                <h1>게시물작성</h1>
            </div>    
        <div class="write_wrap">
            <div class="write">
                <input type="title" placeholder="제목을 입력하세요.">
                <input type="content" placeholder="내용을 입력하세요.">
            </div>
            <div class="addImg_wrap">
                <ul>
                    <li class="imgbox" style="background-image: url(/img/temp/slider1.jpg)">
                        <input type="button" value="삭제" title="삭제"class="bt_delete">
                    </li>
                    <li class="imgbox" style="background-image: url(/img/temp/slider2.jpg)">
                        <input type="button" value="삭제" title="삭제"class="bt_delete">
                    </li>
                    <li class="imgbox" style="background-image: url(/img/temp/slider3.jpg)">
                        <input type="button" value="삭제" title="삭제" class="bt_delete">
                    </li>
                    <li><input type="button" value="추가" title="추가" class="bt_add"></li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>