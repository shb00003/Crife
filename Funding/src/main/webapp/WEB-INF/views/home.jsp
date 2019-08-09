<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" isELIgnored="false"%>
<html>
<head>
<title>Home</title>
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
<%@ include file="include/navbar.jsp"%>
	<h1>Hello world!</h1>회원 번호 : ${login.mem_idx} / 회원 권한 : ${login.mem_type}
	<hr>
	<h2>프로젝트 리스트</h2>
	<c:forEach items="${list}" var="dto">
		<div class="card" style="width: 18rem;">
		<img src="${path}/resources/images/${dto.pro_imageURL}" class="card-img-top" width="100px" height="100px">
		<div class="card-body">
			<h5 class="card-title">${dto.pro_name}</h5>
		<c:choose>
			<c:when test = "${dto.pro_category == 1}">
				<p class="card-text">테크·가전</p>
			</c:when>
			<c:when test = "${dto.pro_category == 2}">
				<p class="card-text">패션·잡화</p>
			</c:when>
			<c:when test = "${dto.pro_category == 3}">
				<p class="card-text">뷰티</p>
			</c:when>
			<c:when test = "${dto.pro_category == 4}">
				<p class="card-text">푸드</p>
			</c:when>
			<c:when test = "${dto.pro_category == 5}">
				<p class="card-text">홈리빙</p>
			</c:when>
			<c:when test = "${dto.pro_category == 6}">
				<p class="card-text">디자인소품</p>
			</c:when>
			<c:when test = "${dto.pro_category == 7}">
				<p class="card-text">여행·레저</p>
			</c:when>
			<c:when test = "${dto.pro_category ==8}">
				<p class="card-text">스포츠·모빌리티</p>
			</c:when>
			<c:when test = "${dto.pro_category == 9}">
				<p class="card-text">반려동물</p>
			</c:when>
			<c:when test = "${dto.pro_category == 10}">
				<p class="card-text">모임</p>
			</c:when>
			<c:when test = "${dto.pro_category == 11}">
				<p class="card-text">공연·컬쳐</p>
			</c:when>
			<c:when test = "${dto.pro_category == 12}">
				<p class="card-text">소셜·캠페인</p>
			</c:when>
			<c:when test = "${dto.pro_category == 13}">
				<p class="card-text">교육·키즈</p>
			</c:when>
			<c:when test = "${dto.pro_category == 14}">
				<p class="card-text">게임·취미</p>
			</c:when>
			<c:when test = "${dto.pro_category == 15}">
				<p class="card-text">출판</p>
			</c:when>
			<c:when test = "${dto.pro_category == 16}">
				<p class="card-text">기부·후원</p>
			</c:when>
		</c:choose>
		<p class="card-text">${dto.day}일 남음</p>
		<a href="${path}/project/detail/${dto.pro_id}" class="btn btn-primary">펀딩 보러가기</a>
		</div>
		</div>
	</c:forEach>

	
	<div class="card" style="width: 18rem;">
	  <img src="images/ryan.jpg" class="card-img-top" alt="ryan">
	  <div class="card-body">
	    <h5 class="card-title">RYAN</h5>
	    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	    <a href="${path}/project/detail/${dto.pro_id}" class="btn btn-primary">펀딩 보러가기</a>
	  </div>
	</div>
	
	<button type="button" id="fbtn">펀딩하기</button>
	<form role="form" id="send_pro_id" method="get"
		action="${path}/reward/step10">
		<!--<input type="hidden" value="${project.pro_id}">  -->
		<input type="hidden" name="pro_id" value="2">
	</form>
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);
			$("#fbtn").on("click", function() {
				formObj.submit();
			});
		});
	</script>
	<hr>
</body>
</html>
