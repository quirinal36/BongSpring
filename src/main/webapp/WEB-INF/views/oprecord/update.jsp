<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="su" uri="tlds/customTags.tld"%>

<!DOCTYPE html>
<html>
<form action="/oprecord/update/save">
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
<td colspan=2><input type="text" name="patientId" value="${item.patientId }"/></td>
<td>환자명 : </td>
<td colspan=3><input type="text" name="patientName" value="${item.patientName }"/></td>
</tr>

<tr><td colspan=6>수술정보</td></tr>
<tr>
<td>수술일 : </td>
<td><input type="text" name="opdate" value="${item.opdate }"/></td>
<td>마취명 : </td>
<td><input type="text" name="anesthesia" value="${item.anesthesia }"/></td>
<td>집도의 : </td>
<td><input type="text" name="doctor" title="집도의" value="${item.doctor }"/></td>
</tr>

<tr><td colspan=6>진단명</td></tr>
<tr><td colspan=6><input type="text" name="dx" value="${item.dx }"/></td></tr>

<tr><td colspan=6>수술명</td></tr>
<tr><td colspan=6><input type="text" name="opname" value="${item.opname }"/></td></tr>

<tr><td colspan=6>OP Findings</td></tr>
<tr><td colspan=6>
<input type="text" name="opfinding" title="OP findings" value="${item.opfinding }"style="width:600px;height:100px"/></td></tr>

<tr><td colspan=6>Procedure</td></tr>
<tr><td colspan=6>
<textarea name="opProcedure" style="width:100%;" rows="15">
${su:replaceBR(item.opProcedure) }
</textarea>
</td></tr>
</tbody>

</table>
<input type="hidden" value="${item.id }" name="id"/>
<input type="submit" value="수정완료"/>
</form>
</html>