<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
$(function() {

	var chkPW = "${chkPW}";
	if(chkPW==="false"){
		alert("비밀번호 불일치. 비밀번호 확인해");
		document.getElementById('myinfoform').mem_password.focus();
	}

	$("#btn_up").click(function() {
		var pw = $("#mem_password").val();
		var repw = $("#mem_repassword").val();
		if (pw == "") {
			alert("비밀번호 입력해");
			document.getElementById('myinfoform').mem_password.focus();
			return;
		}
		if (repw == "") {
			alert("비밀번호 재입력해");
			document.getElementById('myinfoform').mem_repassword.focus();
			return;
		}
		document.getElementById('myinfoform').action = "/funding/user/myinfo_up?mem_idx=${myinfo.mem_idx}";
		document.getElementById('myinfoform').submit();
	});

	$("#btn_del").click(function() {
		var pw = $("#mem_password").val();
		var repw = $("#mem_repassword").val();
		if (pw == "") {
			alert("비밀번호 입력해");
			document.getElementById('myinfoform').mem_password.focus();
			return;
		}
		if (repw == "") {
			alert("비밀번호 재입력해");
			document.getElementById('myinfoform').mem_repassword.focus();
			return;
		}
		document.getElementById('myinfoform').action = "/funding/user/myinfo_del?mem_idx=${myinfo.mem_idx}";
		document.getElementById('myinfoform').submit();
	});

	
	
});
</script>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<form id="myinfoform" method="post">

		<table class="table_view">
			<caption>회원가입</caption>
			<tr>
				<th scope="row">이메일 및 아이디</th>
				<td><input name="mem_email" id="mem_email" type="text" placeholder="이메일 및 아이디" value="${myinfo.mem_email }" readonly="readonly" > </td>
			</tr>
			<tr>
				<th scope="row">비밀번호</th>
				<td><input name="mem_password" id="mem_password" type="password" placeholder="비밀번호" ></td>
			</tr>
			<tr>
				<th scope="row">비밀번호 확인</th>
				<td><input name="mem_repassword" id="mem_repassword" type="password" placeholder="비밀번호 확인"></td>
			</tr>
			<tr>
				<th scope="row">이름</th>
				<td><input name="mem_name" id="mem_name" type="text" placeholder="이름" value="${myinfo.mem_name }"></td>
			</tr>
			<tr>
				<th scope="row">전화번호</th>
				<td><input name="mem_phone" id="mem_phone" type="text" placeholder="전화번호" value="${myinfo.mem_phone }"></td>
			</tr>
			<tr>
				<th scope="row">주민번호</th>
				<td><input name="mem_birth" id="mem_birth" type="number"  maxlength="6" placeholder="생년월일" value="${myinfo.mem_birth }"> - 
					<input name="mem_birth" id="mem_birth" type="text" maxlength="1" width="1" value="${myinfo.mem_sex }">XXXXXX
				</td>
			</tr>
			
			<tr>
				<th scope="row">주소</th>
				<td> 나중에 넣을거임 </td>
			</tr>
			<tr>
				<th scope="row">프로필 이미지 </th>
				<td> 나중에 넣을거임 </td>
			</tr>
			
			
			<tr>
				<th colspan="1"><input type="button" id="btn_up" value="수정">
								<input type="button" id="btn_del" value="탈퇴"></th>
			</tr>
		</table>
	</form>



</body>
</html>