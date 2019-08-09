<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<%@ include file="../include/header.jsp"%>
<!-- 달력관련 css파일들을 불러옵니다. -->
<link rel="stylesheet" href="${path}/resources/pickadate/lib/themes/default.css">
<link rel="stylesheet" href="${path}/resources/pickadate/lib/themes/default.date.css">

<!-- 달력관련 js파일들을 불러옵니다. -->
	<script src="${path}/resources/pickadate/lib/picker.js"></script>
	<script src="${path}/resources/pickadate/lib/picker.date.js"></script>
	<script src="${path}/resources/pickadate/lib/legacy.js"></script>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<form name="input_form" enctype="multipart/form-data" method="post"
		action = "${path}/project/my/detail">
		<table>
			<tr>
				<td>카테고리</td>
			</tr>
			<tr>
				<td>오픈 후, 노출될 카테고리를 선택해 주세요.</td>
			</tr>
			<tr>
				<td><select id="pro_category" name="pro_category">
						<option value="" <c:out value="${detail.pro_category == null ? 'selected' : ''}"/>>프로젝트 카테고리</option>
						<option value="1" <c:out value="${detail.pro_category eq '1' ? 'selected' : ''}"/>>테크·가전</option>
						<option value="2" <c:out value="${detail.pro_category eq '2' ? 'selected' : ''}"/>>패션·잡화</option>
						<option value="3" <c:out value="${detail.pro_category eq '3' ? 'selected' : ''}"/>>뷰티</option> 
						<option value="4" <c:out value="${detail.pro_category eq '4' ? 'selected' : ''}"/>>푸드</option>
						<option value="5" <c:out value="${detail.pro_category eq '5' ? 'selected' : ''}"/>>홈리빙</option>
						<option value="6" <c:out value="${detail.pro_category eq '6' ? 'selected' : ''}"/>>디자인소품</option>
						<option value="7" <c:out value="${detail.pro_category eq '7' ? 'selected' : ''}"/>>여행·레저</option>
						<option value="8" <c:out value="${detail.pro_category eq '8' ? 'selected' : ''}"/>>스포츠·모빌리티</option>
						<option value="9" <c:out value="${detail.pro_category eq '9' ? 'selected' : ''}"/>>반려동물</option>
						<option value="10" <c:out value="${detail.pro_category eq '10' ? 'selected' : ''}"/>>모임</option>
						<option value="11" <c:out value="${detail.pro_category eq '11' ? 'selected' : ''}"/>>공연·컬쳐</option>
						<option value="12" <c:out value="${detail.pro_category eq '12' ? 'selected' : ''}"/>>소셜·캠페인</option>
						<option value="13" <c:out value="${detail.pro_category eq '13' ? 'selected' : ''}"/>>교육·키즈</option>
						<option value="14" <c:out value="${detail.pro_category eq '14' ? 'selected' : ''}"/>>게임·취미</option>
						<option value="15" <c:out value="${detail.pro_category eq '15' ? 'selected' : ''}"/>>출판</option>
						<option value="16" <c:out value="${detail.pro_category eq '16' ? 'selected' : ''}"/>>기부·후원</option>
						</select></td>
			</tr>
			<tr>
				<td>프로젝트 제목</td>
			</tr>
			<tr>
				<td>프로젝트의 핵심 내용을 담을 수 있고 간결한 제목을 정해주세요.</td>
			</tr>
			<tr>
				<td><input type="text" id="pro_name" name="pro_name" value="${detail.pro_name}"></td>
			</tr>
			<tr>
				<td>프로젝트 키워드</td>
			</tr>
			<tr>
				<td>제목 외에도 키워드 검색 시 검색 결과에 프로젝트가 나타납니다.</td>
			</tr>
			<tr>
				<td>#<input type="text" name="pro_keyword1" id="pro_keyword1"  value="${detail.pro_keyword1}">&nbsp; 
					#<input type="text" name="pro_keyword2" id="pro_keyword2"  value="${detail.pro_keyword2}">&nbsp; 
					#<input type="text" name="pro_keyword3" id="pro_keyword3"  value="${detail.pro_keyword3}"></td>
			</tr>
			<tr>
				<td>목표금액</td>
			</tr>
			<tr>
				<td>목표 금액을 적어주세요.</td>
			</tr>
			<tr>
				<td><input type="text" name="pro_price" id="pro_price" value="${detail.pro_price}"></td>
			</tr>
			<tr>
				<td>프로젝트 진행기간</td>
			</tr>
			<tr>
				<td>프로젝트 진행기간을 정해주세요.</td>
			</tr>
			<tr>
				<td><input type="text" name="pro_start" id="pro_start" class="datepicker" value="${detail.pro_start}"> ~
					<input type="text" name="pro_end" id="pro_end" class="datepicker" value="${detail.pro_end}"></td>
			</tr>
			<tr>
				<td>프로젝트 대표 이미지</td>
			</tr>
			<tr>
				<td>프로젝트를 한 눈에 나타낼 수 있는 이미지를 등록해주세요.</td>
			</tr>
			<tr>
				<td>현재 파일 : ${detail.pro_imageURL}&nbsp;<input type="file" name="file1" id="file1" size="50"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="pro_id" value="${detail.pro_id}"></td>
			</tr>
			<tr>
				<td><input type="button" value="저장하기" id='save1' ></td>
			</tr>
		</table>
	</form>
</body>

<!-- //class로 지정된 요소를 변신시킵니다. -->
<script type="text/javascript">
	$('.datepicker').pickadate()
</script>
<script>
$(document).ready(function(){
    //프로젝트등록 유효성검사
    $("#save1").click(function(){
        var pro_name = $("#pro_name").val();
        var pro_price = $("#pro_price").val();
        var pro_start = $("#pro_start").val();
        var pro_end = $("#pro_end").val();
        document.input_form.submit();
        alert("저장되었습니다");
    });
});
</script>
</html>