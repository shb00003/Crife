<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
$(function () {
	$("#btn_write").click(function () {
		var mem_idx = $("#mem_idx")
		location.href="${path}/funding/community/notice/write.do";
	});
});
</script>
<style>

</style>
</head>
<body>
	<%@ include file="../../include/navbar.jsp"%>
<h2>공지사항</h2>회원 권한 : ${type}
<hr>
<table class="table table-hover">
	<thead>
		<tr>
			<th></th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">이메일</th>
			<th scope="col">등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${map.list}">
			<tr>
				<td></td>
				<td><a href="${path}/community/notice/detail.do?notice_idx=${row.notice_idx}">${row.notice_title}</a></td>
				<td>${row.mem_name}</td>
				<td>${row.mem_email}</td>
				<td>${row.notice_date}</td>
			</tr>
		</c:forEach>
	</tbody>
	<c:if test="${type==2}">
	<tfoot>
		<tr>
			<td colspan="4"></td>
			<td>
				<button type="button" class="btn btn-info" id="btn_write">글쓰기</button>
			</td>
		</tr>
	</tfoot>
	</c:if>
</table>
<%@ include file="../../include/page.jsp"%>
</body>
</html>