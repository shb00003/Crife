<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<h2>프로젝트 리스트</h2>
	<c:set var="i" value="0" />
	<c:set var="j" value="3" />
	<table border="1">
		<c:forEach items="${list}" var="dto">
			<c:if test="${i%j == 0 }">
				<tr>
			</c:if>
			<td><img src="${path}/resources/images/${dto.pro_imageURL}"
					width="100px" height="100px"></td>
			<td><a href="${path}/project/detail/${dto.pro_id}">${dto.pro_name}</a></td>
			<c:choose>
				<c:when test = "${dto.pro_category == 1}">
					<td>테크·가전</td>
				</c:when>
				<c:when test = "${dto.pro_category == 2}">
					<td>패션·잡화</td>
				</c:when>
				<c:when test = "${dto.pro_category == 3}">
					<td>뷰티</td>
				</c:when>
				<c:when test = "${dto.pro_category == 4}">
					<td>푸드</td>
				</c:when>
				<c:when test = "${dto.pro_category == 5}">
					<td>홈리빙</td>
				</c:when>
				<c:when test = "${dto.pro_category == 6}">
					<td>디자인소품</td>
				</c:when>
				<c:when test = "${dto.pro_category == 7}">
					<td>여행·레저</td>
				</c:when>
				<c:when test = "${dto.pro_category ==8}">
					<td>스포츠·모빌리티</td>
				</c:when>
				<c:when test = "${dto.pro_category == 9}">
					<td>반려동물</td>
				</c:when>
				<c:when test = "${dto.pro_category == 10}">
					<td>모임</td>
				</c:when>
				<c:when test = "${dto.pro_category == 11}">
					<td>공연·컬쳐</td>
				</c:when>
				<c:when test = "${dto.pro_category == 12}">
					<td>소셜·캠페인</td>
				</c:when>
				<c:when test = "${dto.pro_category == 13}">
					<td>교육·키즈</td>
				</c:when>
				<c:when test = "${dto.pro_category == 14}">
					<td>게임·취미</td>
				</c:when>
				<c:when test = "${dto.pro_category == 15}">
					<td>출판</td>
				</c:when>
				<c:when test = "${dto.pro_category == 16}">
					<td>기부·후원</td>
				</c:when>
				
			</c:choose>
			<td>${dto.day}일 남음</td>
			<c:if test="${i%j == j-1 }">
				</tr>
			</c:if>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
	</table>

</body>
<script>
	$(document).ready(function() {
		$("#update").click(function() {
			document.update_form.submit();
		});
	});
</script>
</html>