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
	$(document).ready(function() {
		$("#btnSave").click(function() {
			var name = $("#maker_name").val();
			if (name == "") {
				alert("이름 입력해");
				document.getElementById('makerform').maker_name.focus();
				return;
			}
			document.getElementById('makerform').submit();
		});
	});
</script>
<meta charset="UTF-8">
<title>메이커 등록</title>
</head>
<body>
	<%@ include file="../include/navbar.jsp"%>
<form id="makerform" action="/funding/maker/makerPOST" method="post">
		
		<table class="table_view">
			<caption>메이커 등록  <input type="text" name = "mem_idx" id="mem_idx" value="${login.mem_idx}"></caption>
			<tr>
				<th scope="row">메이커 이름</th>
				<td><input name="maker_name" id="maker_name" type="text" placeholder="이름"></td>
			</tr>
			<tr>
				<th scope="row">메이커 전화번호</th>
				<td><input name="maker_phone" id="maker_phone" type="text" placeholder="전화번호"></td>
			</tr>
			<tr>
				<th scope="row">주소</th>
				<td>나중에 추가</td>
			</tr>
			<tr>
				<th scope="row">메이커 소개</th>
				<td><input name="maker_intro" id="maker_intro" type="text" placeholder="소개"></td>
			</tr>
			<tr>
				<th scope="row">메이커 이미지</th>
				<td>나중에 추가</td>
			</tr>
			<tr>
				<th colspan="2"><input type="button" id="btnSave" value="확인">
								<input type="reset" value="다시쓰기"></th>
			</tr>
		</table>
	</form>

</body>
</html>