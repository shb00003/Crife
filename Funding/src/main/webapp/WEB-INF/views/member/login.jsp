<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!-- views/member/login.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous">
</script>
<!-- bootstrap 적용 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script>
$(function() {
	$("#btn_Login").click(function() {
		var mem_email = $("#mem_email").val(); //태그의 value 속성값
		var mem_password = $("#mem_password").val();
		if (mem_email == "") {
			alert("아이디를 입력하세요.");
			$("#mem_email").focus(); //입력 포커스 이동
			return; //함수 종료
		}
		if (mem_password == "") {
			alert("비밀번호를 입력하세요.");
			$("#mem_password").focus();
			return;
		}
		//폼 데이터를 서버로 제출
		document.login_form.action = "${path}/member/login_check.do";
		document.login_form.submit();
	});
});
</script>
</head>
<body>
	<%@ include file="../include/navbar.jsp"%>
<h2>로그인</h2>
<form name="login_form" method="post">
	<table border="1" width="400px">
		<tr>
			<td>아이디</td>
			<td><input name="mem_email" id="mem_email"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mem_password" id="mem_password"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" id="btn_Login" value="로그인">
			 <c:if test="${param.message == 'nologin' }">
					<div style="color: red;">로그인 하신 후 사용하세요.</div>
			</c:if> 
			<c:if test="${message == 'error' }">
					<div style="color: red;">아이디 또는 비밀번호가 일치하지 않습니다.</div>
			</c:if>
			 <c:if test="${message == 'logout' }">
					<div style="color: blue;">로그아웃 처리되었습니다.</div>
			</c:if>
			</td>
		</tr>
	</table>
</form>
</body>
</html>