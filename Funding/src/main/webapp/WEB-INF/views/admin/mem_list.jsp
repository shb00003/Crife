<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<%@ include file="../include/navbar.jsp"%>
<table><tr><td height="30px"></td></tr></table>

<table align="center">
<td height="" valign="buttom">
 <select name="mem0" id="mem0">
 <option value="mem_name">회원이름</option>
 <option value="mem_idx">회원번호</option>
 </select></td>
<td><input type="text" neme="mem_search" id="mem_search"></td>
<td>
<input type="button" name="mem" value="조회">
</td>
</tr>
</table>

<table align="center" border="1" >
<tr>
<td>이름</td>
<td>이메일</td>
<td>연락처</td>
<td>생년월일</td>
<td>성별</td>
</tr>
<c:forEach var="row" items="${member}">
<tr>
<td>${row.mem_name}</td>
<td>${row.mem_email}</td>
<td>${row.mem_phone}</td>
<td>${row.mem_birth}</td>
<td>${row.mem_sex}</td>
</tr>
</c:forEach>
</table>
</body>
</html>