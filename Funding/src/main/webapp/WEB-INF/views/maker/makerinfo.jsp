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

	$("#btn_up").click(function() {
		document.getElementById('makerform').action = "/funding/maker/maker_up?maker_idx=${maker.maker_idx}";
		document.getElementById('makerform').submit();
	});

	$("#btn_del").click(function() {
		document.getElementById('makerform').action = "/funding/maker/maker_del?maker_idx=${maker.maker_idx}";
		document.getElementById('makerform').submit();
	});

	
	
});
</script>
<meta charset="UTF-8">
<title>메이커 정보</title>
</head>
<body>
	<%@ include file="../include/navbar.jsp"%>
<form id="makerform" method="post">
		
		<table class="table_view">
			<caption>메이커 정보 <input type="hidden" name="mem_idx" id="mem_idx" value="${maker.mem_idx}"> </caption>
			<tr>
				<th scope="row">메이커 이름</th>
				<td><input name="maker_name" id="maker_name" type="text" placeholder="이름" value="${maker.maker_name }"></td>
			</tr>
			<tr>
				<th scope="row">메이커 전화번호</th>
				<td><input name="maker_phone" id="maker_phone" type="text" placeholder="전화번호" value="${maker.maker_phone}"></td>
			</tr>
			<tr>
				<th scope="row">주소</th>
				<td>나중에 추가</td>
			</tr>
			<tr>
				<th scope="row">메이커 소개</th>
				<td><input name="maker_intro" id="maker_intro" type="text" placeholder="소개" value="${maker.maker_intro }"></td>
			</tr>
			<tr>
				<th scope="row">메이커 이미지</th>
				<td>나중에 추가</td>
			</tr>
			<tr>
				<th colspan="2"><input type="button" id="btn_up" value="수정">
								<input type="button" id="btn_del" value="탈퇴"></th>
			</tr>
		</table>
	</form>

</body>
</html>