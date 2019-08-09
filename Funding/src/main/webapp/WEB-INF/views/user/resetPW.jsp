<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>    
<style type="text/css">
.table_view {
	width: 300px;
	margin: 0 auto;
}

.table_view tfoot {
	text-align: center;
}
</style>
<script src="<c:url value='/webjars/jquery/3.4.1/dist/jquery.min.js' />"></script>
<script type="text/javascript">

	var msg = "${expired}";
	if(msg=="expired"){
		alert("만료된 링크입니다.");
		self.location='<c:url value="/"/>';
	} 
	
	$(document).ready(function() {
		$("#btn").click(function() {
			var pw = $("#mem_password").val();
			var repw = $("#mem_repassword").val();
			if (pw != repw) {
				alert("비밀번호 입력값이 다릅니다. 확인해 주세요.");
				document.getElementById('resetpwform').mem_password.focus();
				return;
			}
			document.getElementById('resetpwform').submit();
		});
	});
</script>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기</title>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<form id="resetpwform" action="/funding/user/resetpw" method="post">

		<table class="table_view">
			<caption>비밀번호 재설정</caption>
			
			<tr>
				<th scope="row">비밀번호</th>
				<td><input name="mem_password" id="mem_password" type="password" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<th scope="row">비밀번호 확인</th>
				<td><input name="mem_repassword" id="mem_repassword" type="password"	placeholder="비밀번호 확인"></td>
			</tr>
			<tr>
				
				<th colspan="3"><input type="button" id="btn" value="완료">
								<input type="hidden" name="email_key" value="${email_key }">
								<input type="hidden" name="mem_email" value="${mem_email }">
				</th>
			</tr>
		</table>
</form>


</body>
</html>