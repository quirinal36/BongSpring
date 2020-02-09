<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title> 어디아포 - 회원가입 </title>
    <link rel="stylesheet" href="<c:url value="/resources/css/css.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/member.css"/>"/>
    <script src="<c:url value="/resources/js/jquery-1.12.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.bxslider.js"/>"></script>
    <script src="<c:url value="/resources/js/index.js"/>"></script>
    <script src="<c:url value="/resources/js/common.js"/>"></script>
    <script type="text/javascript">
	function formSubmit(){
		var uniqueId = $("input[name='uniqueId']").val();
		var pwd = $("input[name='password']").val();
		var pwd_confirm = $("input[name='password_confirm']").val();
		var name = $("input[name='name']").val();
		var sex = $("input[name='sex']").val();
		var birth = $("input[name='birth']").val();
		
		if(uniqueId.length < 1){
			var errorSpan = $("input[name='uniqueId']").parent().find("span");
			errorSpan.text("아이디를 입력 해주세요.");
			errorSpan.fadeIn();
			$("input[name='uniqueId']").focus();
			return false;
		}else{
			var errorSpan = $("input[name='uniqueId']").parent().find("span");
			errorSpan.hide();
		}
		if(pwd.length < 8){
			var errorSpan = $("input[name='password']").parent().find("span");
			errorSpan.text("비밀번호를 8자리 이상 입력하세요.");
			errorSpan.fadeIn();
			$("input[name='password']").focus();
			return false;
		}else{
			var errorSpan = $("input[name='password']").parent().find("span");
			errorSpan.hide();
		}
		if(pwd != pwd_confirm){
			var errorSpan = $("input[name='password_confirm']").parent().find("span");
			errorSpan.text("비밀번호가 일치하지 않습니다.");
			errorSpan.fadeIn();
			$("input[name='password_confirm']").focus();
			return false;
		}else{
			var errorSpan = $("input[name='password_confirm']").parent().find("span");
			errorSpan.hide();
		}
		if( !name ){
			var errorSpan = $("input[name='name']").parent().find("span");
			errorSpan.text("이름을 입력하세요.");
			errorSpan.fadeIn();
			$("input[name='name']").focus();
			return false;
		}else{
			var errorSpan = $("input[name='name']").parent().find("span");
			errorSpan.hide();
		}
		/* if(sex.length < 1){
			var errorSpan = $("input[name='sex']").parent().find("span");
			errorSpan.text("성별을 입력하세요.");
			errorSpan.fadeIn();
			$("input[name='sex']").focus();
			return false;
		}else{
			var errorSpan = $("input[name='sex']").parent().find("span");
			errorSpan.hide();
		} */
		if( birth.length < 8 ){
			var errorSpan = $("input[name='birth']").parent().find("span");
			errorSpan.text("생년월일을 입력하세요.(YYYYMMDD 예) 19891012 )");
			errorSpan.fadeIn();
			$("input[name='birth']").focus();
			return false;
		}else{
			var errorSpan = $("input[name='birth']").parent().find("span");
			errorSpan.hide();
		}
		
		
		
		if(confirm("회원가입 하시겠습니까?")){
			// $("form").submit();
			var url = $("form").attr("action");
			var param = $("form").serialize();
			$.ajax({
				url : url,
				data: param,
				type: "POST"
			}).done(function(resp){
				var callback = JSON.parse(resp);
				if(callback.result > 0){
					if(confirm("회원가입이 완료되었습니다. 로그인화면으로 이동합니다.")){
						window.location.replace("/member/login?loginid="+$("input[name='uniqueId']").val());
					}
				}
			});
		}
	}
	</script>
</head>
<body>
    <div id="wrap">
        <div class="doctor_signup_wrap">
            <div>
                <h2>
                <span>계정</span>을<br>
                생성합니다.
                </h2>
				<form method="post" action="<c:url value="/member/insert"/>">
                   <dl>
                        <dt>아이디 *</dt>
                        <dd><input type="name" name="uniqueId" placeholder="ID">
                        <span style="font-size:12px; color:red; display:none;">error</span></dd>
                        
                   </dl>
                   <div class="name_wrap">
                   <dl class="pass">
                        <dt>비밀번호 *</dt> 
                        <dd><input type="password" name="password" placeholder="*******">
                        	<span style="font-size:12px; color:red; display:none;">error</span></dd>
						<dt>비밀번호 확인</dt>
						<dd><input type="password" name="password_confirm" placeholder="*******">
						<span style="font-size:12px; color:red; display:none;">error</span></dd>
					</dl>
					</div>
                    <div class="name_wrap">
                        <dl>
                            <dt>이름 *</dt>
                            <dd><input type="name" name="name" placeholder="홍길동">
                            <span style="font-size:12px; color:red; display:none;">error</span></dd>
                        </dl>
                        <dl>
                            <dt>성별 *</dt>
                            <dd>
                            	<select name="sex">
									<option>성별 선택</option>
									<option value="m">남자</option>
									<option value="f">여자</option>
								</select>
								
                            </dd>
                        </dl>
                    </div>
                    <dl>
                        <dt>생년월일 *</dt>
                        <dd><input type="year" name="birth" placeholder="YYYYMMDD">
                        <span style="font-size:12px; color:red; display:none;">error</span></dd>
                    </dl>
                    <dl>
                        <dt>전화번호 *</dt>
                        <dd><input type="phone" name="phone" placeholder="010-0000-0000"></dd>
                    </dl>
                    <dl>
                        <dt>이메일 *</dt>
                        <dd><input type="mail" name="email" placeholder="abc@myapo.com"></dd>
                    </dl>
                    <dl>
                        <dt>주소 *</dt>
                        <dd><input type="address" name="address" placeholder="주소"></dd>
                    </dl>
                    <div class="name_wrap">
                        <dl>
                            <dt>직장명 *</dt>
                            <dd>
								<select name="company_id">
									<option>기관 선택</option>
									<c:forEach items="${companyList}" var="item">
										<option value="${item.id }">${item.name }</option>
									</c:forEach>
								</select>
							</dd>
                        </dl>
                        <dl>
                            <dt>부서 *</dt>
                            <dd>
								<select name="department_id">
									<option>부서선택</option>
									<c:forEach items="${departmentList }" var="item">
										<option value="${item.id }">${item.name }</option>
									</c:forEach>
								</select>
							</dd>
                        </dl>
                        <dl>
                            <dt>직책 *</dt>
                            <dd><input type="position" name="position" placeholder="ex) 정형외과 전문의"></dd>
                        </dl>
                    </div>    
                    
                    <div>
                        <input type="checkbox" id="save_info">
                        <label for="save_info"><span>가입시 서비스와 개인정보 수집에 동의하십니까?</span></label>
                    </div>
                    <input type="button" value="회원가입" class="bt_signup" onclick="javascript:formSubmit();"/>
                </form>
            </div>
        </div>
    </div>
</body>
</html>