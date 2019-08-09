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

	var msg = "${msg}";
	var find = "${find}";
	if(msg=='0'){
		alert(find+"는 존재하디 않는 입니다. 회원가입해 주세요.");
		self.location='<c:url value="/user/join"/>';
	}else if(msg=='1'){
		alert(find+"는 존재하는 회원 입니다. 로그인해 주세요.");
		self.location='<c:url value="/user/login"/>';
	}else if(msg=='email'){
		alert(find+"로  발송완료. 비밀번호를 재설정 해주세요.");
	}

	$(document).ready(function() {
		$("#btnid").click(function() {
			var find = $("#find").val();
			if (find == "") {
				alert("id 입력해야 찾아주지ㅠ");
				document.getElementById('findidform').find.focus();
				return;
			}
			document.getElementById('findidform').submit();
		});
	});

	$(document).ready(function() {
		$("#btnpw").click(function() {
			var findpw = $("#findpw").val();
			if (findpw == "") {
				alert("pw 입력해야 찾아주지ㅠ");
				document.getElementById('findpwform').findpw.focus();
				return;
			}
			document.getElementById('findpwform').submit();
		});
	});
</script>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기</title>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<form id="findidform" action="/funding/user/userfind_id" method="post">

		<table class="table_view">
			<caption>아이디 찾기</caption>
			<tr>
				<th><input name="find" id="find" type="text" placeholder="이메일 계정"> </td>
			</tr>
			<tr>
				<th ><input type="button" id="btnid" value="확인"></th>
			</tr>
		</table>
</form>

<br><br>
<br><br>


<form id="findpwform" action="/funding/user/userfind_pw" method="post">

		<table class="table_view">
			<caption>비밀번호 재설정</caption>
			
			<tr><td>가입하셨던 이메일 계정을 입력하시면,</td></tr>
			<tr><td>비밀번호를 새로 만들 수 있는 링크를 </td></tr>
			<tr><td>이메일로 발송해드립니다.</td></tr>
			<tr>
				<th><input name="findpw" id="findpw" type="text" placeholder="이메일  계정"> </td>
			</tr>
			<tr>
				<th colspan="3"><input type="button" id="btnpw" value="링크 발송"></th>
			</tr>
		</table>
</form>


</body>
</html>