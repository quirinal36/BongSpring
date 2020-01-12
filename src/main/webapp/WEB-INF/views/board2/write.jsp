<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
				<form id="write" action="<c:url value="/board2/write"/>" method="post">
					<table>
						<colgroup>
							<col width="30%">
							<col width="70%">
						</colgroup>
						<thead>
							<tr>
								<th colspan="2">
									사진정보 업로드								
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>등록번호</td>
								<td><input type="text" name="regNo" placeholder="등록번호" required/></td>
							</tr>
							<tr>
								<td>환자이름</td>
								<td><input type="text" name="patientName" placeholder="환자이름" required/></td>
							</tr>
							<tr>
								<td>등록담당자</td>
								<td><input type="text" name="uploader" placeholder="등록담당자" value="${user.username }" required/></td>
							</tr>
							<tr>
								<td>분류</td>
								<td><input type="text" name="specification" placeholder="분류"/></td>
							</tr>
							<tr>
								<td>찍은날짜</td>
								<td><input type="text" name="issuedAt" placeholder="찍은날짜" value="${today }"/></td>
							</tr>
							
						</tbody>
					</table>
					<input id="fileupload" type="file" name="files[]" 
						accept="image/x-png,image/gif,image/jpeg" data-url="<c:url value="/upload"/>" multiple>
				    <div id="progress">
				        <div style="width: 0%;"></div>
				    </div>
				    <table id="uploaded-files">
				    	<thead>
				    		<tr>
								<th colspan="3">사진업로드</th>
							</tr>
						</thead>
						<tbody>
					        <tr>
					            <th>파일명</th>
					            <th>Size</th>
					            <th>Type</th>
					        </tr>
				        </tbody>
				    </table>
					<input type="hidden" value="<c:url value="/upload/get"/>" name="uploadUrl">
					<input type="hidden" value="<c:url value="/upload/clear"/>" name="clearUrl">
					<input type="button" value="글작성" onclick="javascript:insertBoard();">
				</form>
			</div>
</body>
</html>