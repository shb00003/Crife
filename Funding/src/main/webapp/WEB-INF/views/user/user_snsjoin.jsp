<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.table_view {
	width: 600px;
	margin: 0 auto;
}

.table_view tfoot {
	text-align: center;
}
</style>
<script src="<c:url value='/webjars/jquery/3.4.1/dist/jquery.min.js' />"></script>
<script type="text/javascript">
	var msg = "${msg}";

	if (msg === "0") {
		alert("가입되어 있지 않은 회원입니다. 회원가입을 해 주세요.");
	}else if (msg === "3") {
		alert("탈퇴를 신청했던 계정입니다.");
		self.location = '<c:url value="/user/login"/>';
	}

	$(document).ready(function() {
		$("#btnSave").click(function() {
			var email = $("#mem_email").val();
			if (email == "") {
				alert("이메일 입력해");
				document.getElementById('joinform').mem_email.focus();
				return;
			}
			document.getElementById('joinform').submit();
		});
	});
</script>
<meta charset="UTF-8">
<title>sns회원가입</title>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
	<form id="joinform" action="/funding/user/snsjoinPOST" method="post">

		<table class="table_view">
			<input name="naver_idx" id="naver_idx" type="text"
				value="${snsUser.naver_idx}">
			<caption>sns회원가입</caption>
			<tr>
				<th scope="row">이메일</th>
				<td><input name="mem_email" id="mem_email" type="text"
					placeholder="이메일 "></td>
			</tr>
			<tr>
				<th scope="row">비밀번호</th>
				<td><input name="mem_password" id="mem_password"
					type="password" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<th scope="row">비밀번호 확인</th>
				<td><input name="mem_repassword" id="mem_repassword"
					type="password" placeholder="비밀번호 확인"></td>
			</tr>
			<tr>
				<th scope="row">이름</th>
				<td><input name="mem_name" id="mem_name" type="text"
					placeholder="이름" value="${snsUser.mem_name }"></td>
			</tr>
			<tr>
				<th scope="row">전화번호</th>
				<td><input name="mem_phone" id="mem_phone" type="text"
					placeholder="전화번호"></td>
			</tr>
			<tr>
				<th scope="row">주민번호</th>
				<td><input name="mem_birth" id="mem_birth" type="text"
					maxlength="6" placeholder="생년월일"> - <input name="mem_sex"
					id="mem_sex" type="text" maxlength="1" value="${snsUser.mem_sex}">XXXXXX</td>
			</tr>
			<tr>
				<th colspan="2"><input type="button" id="btnSave" value="확인">
					<input type="reset" value="다시쓰기"></th>
			</tr>
		</table>
	</form>

</body>
</html>