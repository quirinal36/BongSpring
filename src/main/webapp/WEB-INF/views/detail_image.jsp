<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>상세이미지</title>
    <link rel="stylesheet" href="/css/css.css">
    <link rel="stylesheet" href="/css/detail_image.css">
    <script src="/js/jquery-1.12.1.min.js"></script>
    <script src="/js/jquery.bxslider.js"></script>
    <script src="/js/index.js"></script>
    <script src="/js/common.js"></script>
    <script>
    $(function(){        
        $(".detail_image_wrap .menu_wrap > a ").click(function(){
            $(this).find("+ .menu").toggle();
        });

        $(".caption_wrap").click(function(){
            $(this).toggleClass("on");
        });
    });
    </script>
</head>
<body>
    <div class="detail_image_wrap">
        <div class="top">
            <a href="history.back();">이전페이지</a>
            <div class="menu_wrap">
                <a href="javascript:void(0);">메뉴</a>
                <div class="menu">
                        <a href="#">수정</a>
                        <a href="#">삭제</a>
                    </ul>
                </div>
            </div>
        </div>    
        <div class="image_wrap">
            <div>
                <img src="/img/temp/slider1.jpg" alt="사진">
            </div>    
            <div class="caption_wrap">
                <p>인대파열 정도가 심하지 않은 경우라면 약물이나 인대파열 정도가 심하지 않은 경우라면 약물이나인대파열 정도가 심하지 않은 경우라면 약물이나인대파열 정도가 심하지 않은 경우라면 약물이나인대파열 정도가 심하지 않은 경우라면 약물이나주사 그리고 도수물리 운동 등의 보존적인 처치로 증상 개선을 도와드릴 수 있습니다.</p>
            </div>
        </div>     
    </div>    
</body>
</html>