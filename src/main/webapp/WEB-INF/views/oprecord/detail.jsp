<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<table border="1">
<thead>
<tr>
<td colspan=6>수술기록지</td>
</tr>
</thead>

<tbody>
<tr><td colspan=6>환자정보</td></tr>
<tr>
<td>등록번호 : </td>
<td colspan=2>${item.patientId }</td>
<td>환자명 : </td>
<td colspan=3>${item.patientName }</td>
</tr>

<tr><td colspan=6>수술정보</td></tr>
<tr>
<td>수술일 : </td>
<td>${item.opdate }</td>
<td>마취명 : </td>
<td>${item.anesthesia }</td>
<td>집도의 : </td>
<td>${item.doctor }</td>
</tr>

<tr><td colspan=6>진단명</td></tr>
<tr><td colspan=6>${item.dx }</td></tr>

<tr><td colspan=6>수술명</td></tr>
<tr><td colspan=6>${item.opname }</td></tr>

<tr><td colspan=6>OP Findings</td></tr>
<tr><td colspan=6>
<c:if test = "${fn:length(item.opfinding) == 1}">&nbsp;</c:if>
<c:if test = "${fn:length(item.opfinding) > 1}">${item.opfinding }</c:if>
</td></tr>

<tr><td colspan=6>Procedure</td></tr>
<tr><td colspan=6>${item.opProcedure }</td></tr>
</tbody>

</table>

<input type="button" value="수정" onclick="window.location.href='/oprecord/update/${item.id}'"/>