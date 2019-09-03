<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<br>
	<%@ include file="../include/admin_menu.jsp"%>
	<br>
	<table>
		<tr>
			<td height="30px"></td>
		</tr>
	</table>

	<table align="center" border="1">
		<tr>
			<td>관리자 아이디</td>
			<td>관리자 이름</td>
			<td>관리자 이메일</td>
			<td>관리자 권한</td>
		<tr>
			<c:forEach var="mana" items="${list}">
				<td>${mana.admin_id}</td>
				<td>${mana.admin_name}</td>
				<td>${mana.admin_email}</td>
				<td><c:choose>
						<c:when test="${mana.admin_type=='1'}">최고관리자</c:when>
						<c:when test="${mana.admin_type=='2'}">관리자</c:when>
					</c:choose></td>
			</c:forEach>
			
		</tr>
	</table>
</body>
</html>