<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../include/header.jsp"%>
<title>check</title>
<script>
function check() {
	document.check_form.submit();
}
</script>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
	<form method="post" action="${path}/project/add" name="check_form">
		<!-- 프로젝트 제목 : <input type="text" name="pro_name"><br> -->
		<input type="checkbox" name="chk_info" value="1">1<br>
		<input type="checkbox" name="chk_info" value="1">2<br>
		<input type="checkbox" name="chk_info" value="1">3<br>
		<input type="hidden" name="mem_idx" value="${login.mem_idx}">
		<button type="button" onclick="check()">다음으로</button>
	</form>
	
</body>
</html>