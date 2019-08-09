<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
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
<script type="text/javascript">
	$(function() {
		$("#btn_update").click(function() {
			document.detail_form.submit();
		});
	}); 
	$(function() {
		$("#btn_delete").click(function() {
			if(confirm("삭제하시겠습니까?")){
				document.detail_form.action="${path}/notice/delete.do";
				document.detail_form.submit();
			}
	//		location.href = "${path}/community/notice/delete.do";
		});
	});
</script>
</head>
<body>
	<%@ include file="../../include/navbar.jsp"%>
<h2>공지사항</h2>
<hr>
<c:choose>	
	<c:when test="${type==2}">
	<form name="detail_form" method="post" action="${path}/community/notice/update/${notice_idx}">
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label> 
			<input type="text" class="form-control" id="notice_title" value="${dto.notice_title}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">작성자</label> 
			<input type="text" class="form-control" id="mem_name" readonly="readonly" value="${dto.mem_name}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">등록일</label> 
			<input type="text" class="form-control" id="notice_date" readonly="readonly" value="${dto.notice_date}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">내용</label>
			<textarea class="form-control" id="notice_content" rows="10">${dto.notice_content}</textarea>
		</div>
		<input type="hidden" name="notice_idx" value="${dto.notice_idx}">
		<button type="button" class="btn btn-info" id="btn_update">수정</button>
		<button type="button" class="btn btn-info" id="btn_delete">삭제</button>
	</form>
	</c:when>
	<c:otherwise>
	<form>
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label> 
			<input type="text" class="form-control" id="exampleFormControlInput1" readonly="readonly" value="${dto.notice_title}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">작성자</label> 
			<input type="text" class="form-control" id="exampleFormControlInput1" readonly="readonly" value="${dto.mem_name}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">등록일</label> 
			<input type="text" class="form-control" id="exampleFormControlInput1" readonly="readonly" value="${dto.notice_date}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">내용</label>
			<textarea class="form-control" id="exampleFormControlTextarea1" rows="10" readonly="readonly">${dto.notice_content}</textarea>
		</div>
	</form>
	</c:otherwise>
</c:choose>
</body>
</html>