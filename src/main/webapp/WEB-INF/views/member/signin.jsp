<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title> 어디아포 - 회원가입 </title>
    <link rel="stylesheet" href="/css/css.css">
    <link rel="stylesheet" href="/css/member.css">
    <script src="/js/jquery-1.12.1.min.js"></script>
    <script src="/js/jquery.bxslider.js"></script>
    <script src="/js/index.js"></script>
    <script src="/js/common.js"></script>
</head>
<body>
    <div id="wrap">
        <div class="doctor_signup_wrap">
            <div>
                <h2>
                <span>계정</span>을<br>
                생성합니다.
                </h2>
                <form>
                    <div class="name_wrap">
                        <dl>
                            <dt>이름</dt>
                            <dd><input type="name" placeholder="홍길동"></dd>
                        </dl>
                        <dl>
                            <dt>성별</dt>
                            <dd><input type="gender" placeholder="남자/여자"></dd>
                        </dl>
                    </div>
                    <dl>
                        <dt>생년월일</dt>
                        <dd><input type="year" placeholder="YYYY/MM/DD"></dd>
                    </dl>
                    <dl>
                        <dt>전화번호</dt>
                        <dd><input type="phone" placeholder="010-0000-0000"></dd>
                    </dl>
                    <dl>
                        <dt>이메일</dt>
                        <dd><input type="mail" placeholder="abc@myapo.com"></dd>
                    </dl>
                    <dl>
                        <dt>주소</dt>
                        <dd><input type="address" placeholder="서울시 종로구"></dd>
                    </dl>
                    <div class="name_wrap">
                        <dl>
                            <dt>직장명</dt>
                            <dd><input type="work" placeholder="서울대학교 병원"></dd>
                        </dl>
                        <dl>
                            <dt>직책</dt>
                            <dd><input type="position" placeholder="정형외과 전문의"></dd>
                        </dl>
                    </div>    
                    <dl class="pass">
                        <dt>비밀번호</dt> 
                        <dd><input type="password" placeholder="*******"></dd>
                    </dl>
                    <div>
                        <input type="checkbox" id="save_info">
                        <label for="save_info"><span>가입시 서비스와 개인정보 수입에 동의하십니까?</span></label>
                    </div>
                </form>
                <a href="#" class="bt_signup">회원가입</a>   
            </div>
        </div>
    </div>
</body>
</html>