<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
	<!-- 스마트 에디터 적용 -->
	<script src="${path}/ckeditor/ckeditor.js"></script> 
	
<!-- include libraries(jQuery, bootstrap) -->
<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
 -->
	<script type="text/javascript">
		$(function () {
			$("#btn_cancel").click(function () {
				location.href="${path}/community/notice/notice.do";
			});
		});
		$(function () {
			$("#btn_ok").click(function() {
				document.write_form.submit();
			});
		});
	</script>
</head>
<body>
	<%@ include file="../../include/navbar.jsp"%>
<h2>글쓰기</h2>회원 번호 : ${idx}
<hr>
<form name="write_form" method="post" action="${path}/community/notice/insert.do">
  <div class="form-group">
    <label for="exampleFormControlInput1">제목</label>
    <input type="text" class="form-control" name="notice_title" placeholder="제목을 입력하세요.">
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">작성자</label>
    <input type="text" class="form-control" name="mem_name" placeholder="이름을 입력하세요.">
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">내용</label>
    <textarea class="form-control" name="notice_content" rows="10" placeholder="내용을 입력하세요."></textarea>
<!--   <script>
  // 스마트 에디터 적용
  // id가 description인 태그에 ckditor 적용.
  CKEDITOR.replace("content");
  </script> -->
  <input type="hidden" value="${idx}">
  </div>
</form>
<button type="button" class="btn btn-info" id="btn_ok">완료</button>
<button type="button" class="btn btn-info" id="btn_cancel">취소</button>
</body>
</html>