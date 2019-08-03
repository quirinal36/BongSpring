<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/member.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	$(function(){
		$("input[name='uniqueId']").on('keyup', function(event){
			console.log(event);
			var url = $(this).parent().find("input[type='hidden']").val();
			url = url +"/" + $(this).val();
			findPerson(url);
		});
	});
	function findPerson(url){
		$.ajax({
			url : url,
			type : "GET"
		}).done(function(resp){
			var errorSpan = $("input[name='uniqueId']").parent().find("span");
			if(resp.num > 0){
				errorSpan.text("이미 가입된 정보가 있습니다.");
				errorSpan.fadeIn();
			}else{
				errorSpan.hide();
			}
		});
	}
	function formSubmit(){
		var uniqueId = $("input[name='uniqueId']").val();
		var pwd = $("input[name='password']").val();
		var pwd_confirm = $("input[name='password_confirm']").val();
		
		if(uniqueId.length < 1){
			var errorSpan = $("input[name='uniqueId']").parent().find("span");
			errorSpan.text("사번을 입력 해주세요.");
			errorSpan.fadeIn();
			return false;
		}
		
		if(pwd.length < 1){
			//alert("비밀번호를 1자 이상으로 설정해주세요.");
			var errorSpan = $("input[name='password']").parent().find("span");
			errorSpan.text("비밀번호를 1자 이상으로 설정해주세요.");
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
		
		if(confirm("회원가입 하시겠습니까?")){
			$("form").submit();
		}
	}
	</script>
</head>
<body>
<div class="wrap">
<header><c:import url="/inc/header"></c:import></header>
<div class="container_wrap">
<div class="container">
<!-- 컨텐츠 시작 -->

<div id="join_step2" class="page member">
	<form method="post" action="<c:url value="/member/insert"/>">
		
		<div class="info">
			<strong>회원가입</strong>
			<div>
				<dl>
					<dt>사번 *</dt>
					<dd>
					<input type="text" name="uniqueId" placeholder="사번을 입력하세요." required/>
					<input type="hidden" name="findUrl" value="<c:url value="/member/get"/>"/>
					<span style="color:red; display:none;">error</span>
					</dd>
				</dl>
				<dl>
					<dt>비밀번호 * </dt>
					<dd>
						<input type="password" name="password" placeholder="비밀번호를 입력하세요." required/>
						<span style="color:red; display:none;">error</span>
					</dd>
				</dl>
				<dl>
					<dt>비밀번호 확인 *</dt>
					<dd>
						<input type="password" name="password_confirm"placeholder="비밀번호를 입력하세요." required/>
						<span style="color:red; display:none;">error</span>
					</dd>
				</dl>
				<dl>
					<dt>생년월일 *</dt>
					<dd>
						<input type="password" name="birth" placeholder="19901201" required/>
					</dd>
				</dl>
				<dl>
					<dt>부서정보 *</dt>
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
					<dt>전화번호</dt>
					<dd><input type="text" name="phone" placeholder="전화번호 입력" required/></dd>
				</dl>
			</div>
			
		</div>
			
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