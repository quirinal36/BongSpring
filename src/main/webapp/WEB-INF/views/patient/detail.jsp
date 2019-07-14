<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
		<c:forEach items="${list}" var="item">
			<tr>
				<td colspan="2">
					${item }
				</td>
			</tr>
		</c:forEach>
	</tbody> 
</table>