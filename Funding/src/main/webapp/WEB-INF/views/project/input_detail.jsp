<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input_detail</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<%@ include file="project_navbar.jsp"%>
	<form name="input_form" enctype="multipart/form-data" method="post"
		action="${path}/project/update_page">
		<table>
			<tr>
				<td>카테고리</td>
			</tr>
			<tr>
				<td>오픈 후, 노출될 카테고리를 선택해 주세요.</td>
			</tr>
			<tr>
				<td><c:choose>
				<c:when test = "${detail.pro_category == 1}">
					테크·가전
				</c:when>
				<c:when test = "${detail.pro_category == 2}">
					패션·잡화
				</c:when>
				<c:when test = "${detail.pro_category == 3}">
					뷰티
				</c:when>
				<c:when test = "${detail.pro_category == 4}">
					푸드
				</c:when>
				<c:when test = "${detail.pro_category == 5}">
					홈리빙
				</c:when>
				<c:when test = "${detail.pro_category == 6}">
					디자인소품
				</c:when>
				<c:when test = "${detail.pro_category == 7}">
					여행·레저
				</c:when>
				<c:when test = "${detail.pro_category ==8}">
					스포츠·모빌리티
				</c:when>
				<c:when test = "${detail.pro_category == 9}">
					반려동물
				</c:when>
				<c:when test = "${detail.pro_category == 10}">
					모임
				</c:when>
				<c:when test = "${detail.pro_category == 11}">
					공연·컬쳐
				</c:when>
				<c:when test = "${detail.pro_category == 12}">
					소셜·캠페인
				</c:when>
				<c:when test = "${detail.pro_category == 13}">
					교육·키즈
				</c:when>
				<c:when test = "${detail.pro_category == 14}">
					게임·취미
				</c:when>
				<c:when test = "${detail.pro_category == 15}">
					출판
				</c:when>
				<c:when test = "${detail.pro_category == 16}">
					기부·후원
				</c:when>
			</c:choose></td>
			</tr>
			<tr>
				<td>프로젝트 제목</td>
			</tr>
			<tr>
				<td>프로젝트의 핵심 내용을 담을 수 있고 간결한 제목을 정해주세요.</td>
			</tr>
			<tr>
				<td>${detail.pro_name}</td>
			</tr>
			<tr>
				<td>프로젝트 키워드</td>
			</tr>
			<tr>
				<td>제목 외에도 키워드 검색 시 검색 결과에 프로젝트가 나타납니다.</td>
			</tr>
			<tr>
				<td>#${detail.pro_keyword1}&nbsp; 
					#${detail.pro_keyword2}&nbsp; 
					#${detail.pro_keyword3}</td>
			</tr>
			<tr>
				<td>목표금액</td>
			</tr>
			<tr>
				<td>목표 금액을 적어주세요.</td>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${detail.pro_price}"/>원</td>
			</tr>
			<tr>
				<td>프로젝트 진행기간</td>
			</tr>
			<tr>
				<td>프로젝트 진행기간을 정해주세요.</td>
			</tr>
			<tr>
				<td>${detail.pro_start} ~ ${detail.pro_end}</td>
			</tr>
			<tr>
				<td>프로젝트 대표 이미지</td>
			</tr>
			<tr>
				<td>프로젝트를 한 눈에 나타낼 수 있는 이미지를 등록해주세요.</td>
			</tr>
			<tr>
				<td>현재 파일 : ${detail.pro_imageURL}&nbsp;<img src="${path}/resources/images/${detail.pro_imageURL}"
					width="100px" height="100px"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="pro_id" value="${detail.pro_id}"></td>
			</tr>
			<tr>
				<td><input type="button" value="수정하기" id='update' ></td>
			</tr>
		</table>
	</form>
</body>
<script>
$(document).ready(function(){
    //프로젝트등록 유효성검사
    $("#update").click(function(){
        var pro_name = $("#pro_name").val();
        var pro_price = $("#pro_price").val();
        var pro_start = $("#pro_start").val();
        var pro_end = $("#pro_end").val();
        document.input_form.submit();
    });
});
</script>
</html>