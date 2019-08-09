<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_project</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<%@ include file="../include/navbar.jsp"%>
	<h2>내 프로젝트 목록</h2>
	<c:set var="i" value="0" />
	<c:set var="j" value="3" />
	<table border="1">
		<c:forEach items="${my_pro}" var="dto">
			<c:if test="${i%j == 0}">
				<tr>
			</c:if>
			<td><img src="${path}/resources/images/${dto.pro_imageURL}"width="100px" height="100px"></td>
			<td><a href="${path}/project/detail/${dto.pro_id}">${dto.pro_name}</a></td>
			<c:choose>
				<c:when test="${dto.pro_status == 0}">
					<td>제작중</td>
				</c:when>
				<c:when test="${dto.pro_status == 1}">
					<td>펀딩 진행중</td>
				</c:when>
				<c:when test="${dto.pro_status == 2}">
					<td>요청 대기중</td>
				</c:when>
				<c:when test="${dto.pro_status == 3}">
					<td>종료된 펀딩</td>
				</c:when>
			</c:choose>
			<td>목표금액 : <fmt:formatNumber value="${dto.pro_price}"/>원&nbsp;
			<form name="my_form" method="post" action="${path}/project/update_page" id="my_form">
				<input type="hidden" name="pro_id" value="${dto.pro_id}">
				<input type="button" value="수정하기" class="update">
				<input type="button" value="삭제하기" class="delete">
			</form></td>
			<c:if test="${i%j == j-1}">
				</tr>
			</c:if>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
	</table>
</body>
<script>
	$(document).ready(function() {
		var form = $('#my_form');
		$(".update").click(function(e) {
			e.preventDefault(); // 버튼 기본 이벤트를 막음
			$(this).parent().submit();
		});
		$(".delete").click(function(e) {
			e.preventDefault(); // 버튼 기본 이벤트를 막음
			var result = confirm('정말 삭제하시겠습니까?');
			if(result) { 
				$(this).parent().attr('action','${path}/project/my_delete').submit();
				alert("삭제되었습니다");
			}
		});
	});
</script>
</html>