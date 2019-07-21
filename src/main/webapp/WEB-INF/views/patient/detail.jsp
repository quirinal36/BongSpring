<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<title>환자정보</title>
<style>
.grid { 
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  grid-gap: 20px;
  align-items: stretch;
  }
.grid img {
  border: 1px solid #ccc;
  box-shadow: 2px 2px 6px 0px  rgba(0,0,0,0.3);
  max-width: 100%;
}
</style>


<c:set value="${list[0] }" var="patientInfo"/>
<table border="1">
	<colgroup>
		<col width="20%">
		<col width="80%">
	</colgroup>
	<thead>
		<tr>
			<td>
				PatientId:
			</td>
			<td>
				${patientInfo.patientId }
			</td>
		</tr>
		<tr>
			<td>
				Name:
			</td>
			<td>
				${patientInfo.name }
			</td>
		</tr>
		<tr>
			<td>
				Birth:
			</td>
			<td>
				${patientInfo.birth }
			</td>
		</tr>
		<tr>
			<td>
				Doctor:
			</td>
			<td>
				${patientInfo.doctor }
			</td>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td colspan="2"> 
		<div class="grid">		
			<c:forEach items="${list}" var="item">
				<img src="http://hsbong.synology.me:7070/PatientPhoto/picture/${item.photoId }"/>
			</c:forEach>
		</div>
		</td>
	</tr>
	</tbody> 
</table>