<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<title>Example</title>
<style>
.grid { 
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(800px, 1fr));
  grid-gap: 20px;
  align-items: stretch;
  }
.grid img {
  border: 1px solid #ccc;
  box-shadow: 2px 2px 6px 0px  rgba(0,0,0,0.3);
  max-width: 100%;
}
</style>
<div class="grid">
		<img src="http://hsbong.synology.me:7070/PatientPhoto/picture/${info.id}" alt="Sample photo">
				
</div>