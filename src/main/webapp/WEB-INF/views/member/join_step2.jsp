<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/member.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
	
	<script type="text/javascript">
	function formSubmit(){
		var pwd = $("input[name='password']").val();
		var pwd_confirm = $("input[name='password_confirm']").val();
		
		console.log("pwd: " + pwd);
		console.log("pwd_confirm: " + pwd_confirm);
		if(pwd.length < 8){
			toast({text:"비밀번호를 8자 이상으로 설정해주세요."});
			$("input[name='password']").focus();
			return false;
		}
		if(pwd != pwd_confirm){
			toast({text:"비밀번호가 일치하지 않습니다."});
			$("input[name='password_confirm']").focus();
			return false;
		}
		var checked = $("#join_chk").is(":checked");
		console.log("checked: " + checked);
		
		if(checked == false){
			toast({text:"이용약관에 동의해주세요."});
			return false;
		}
		var nickname = $("input[name='nickname']");
		if(nickname.val().length == 0){
			toast({text:"닉네임을 입력해주세요."});
			nickname.focus();
			return false;
		}
		
		swal({
			text : '회원가입 하시겠습니까?',
			showCancelButton: true,
			focusConfirm: false,
			confirmButtonText: '네',
			cancelButtonText : '닫기',
			animation: false
		}).then(function(result){
			if(result.value){
				$("form").submit();
			}
		})
	}
	</script>
</head>
<body>
<div id="wrap">
<header><c:import url="/inc/header"></c:import></header>
<div id="container_wrap">
<div id="container">
<!-- 컨텐츠 시작 -->
<h2 class="title">회원가입</h2>
<div class="step">
	<div><span>01</span>본인인증</div>
	<div class="on"><span>02</span>정보입력</div>
	<div><span>03</span>가입완료</div>
</div>
<div id="join_step2" class="page member">
	<form method="post" action="/member/insert">
		<div class="terms">
			<strong>이용약관</strong>
			<div>내용 준비 중입니다.</div>
			<strong>개인정보처리방침</strong>
			<div>내용 준비 중입니다.</div>
			<input type="checkbox" id="join_chk" class="chk1" name="check"/>
			<label for="join_chk"><span>(필수)</span> 이용약관과 개인정보처리방침에 동의합니다.</label>
		</div>
		<div class="info">
			<strong>정보입력</strong>
			<div>
				<dl>
					<dt>아이디</dt>
					<dd>${user.user_phon }</dd>
				</dl>
				<dl>
					<dt>비밀번호</dt>
					<dd>
						<input type="password" name="password"/>
						<input type="button" class="icon_q" value="도움말" />
					</dd>
				</dl>
				<dl>
					<dt>비밀번호 확인</dt>
					<dd><input type="password" name="password_confirm"/></dd>
				</dl>
			</div>
			<div>
				<dl>
					<dt>이름</dt>
					<dd>${user.username}</dd>
				</dl>
				<dl>
					<dt>활동명</dt>
					<dd><input type="text" name="nickname"/></dd>
				</dl>
				<dl>
					<dt>생년월일</dt>
					<dd>${user.birth }</dd>
				</dl>
			</div>
		</div>
		<input type="hidden" name="user_phon" value="${user.user_phon }"/>
		<input type="hidden" name="birth" value="${user.birth }"/>
		<input type="hidden" name="username" value="${user.username }"/>		
		<input type="button" value="회원가입" class="bt1" onclick="javascript:formSubmit();"/>
	</form>
</div>
<!-- 컨텐츠 끝 -->
</div>
</div>
<footer><c:import url="/inc/footer"></c:import></footer>
</div>
</body>
</html>