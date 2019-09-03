<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
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
<center>
	<br>
	<%@ include file="../include/admin_menu.jsp"%>

    <br>
    <form name="Search" method="post" action="${path}/admin/projectall.do">
    <select name="searchOption" id="searchOption">
 <option value="pro_all" <c:if test="${map.searchOption=='pro_all'}">selected</c:if> >전체조회</option>
 <option value="pro_name" <c:if test="${map.searchOption=='pro_name'}">selected</c:if> >프로젝트 제목</option>
 <option value="pro_id" <c:if test="${map.searchOption=='pro_id'}">selected</c:if> >프로젝트 번호</option>
 <option value="maker_name"<c:if test="${map.searchOption=='maker_name'}">selected</c:if> >메이커명</option>
 <option value="maker_idx" <c:if test="${map.searchOption=='maker_idx'}">selected</c:if> >메이커 번호</option>
 </select>
 <input name="keyword" value="${map.keyword}">
 <input type="submit" value="조회">
 </form>
 <br>
<!--  레코드의 갯수를 출력 -->
${map.count}개의 프로젝트가 조회되었습니다.<p>

	<table align="center" border="1">
		<tr>
			<th>No</th>
			<th colspan="2">프로젝트명</th>
			<th>메이커</th>
			<th>프로젝트 시작일</th>
			<th>상태</th>
		</tr>
			<c:forEach var="ad" items="${map.list}">
				<tr>
					<td>${ad.pro_id}</td>
					<td><img src="${path}/images/${ad.pro_imageURL}" width="100px"
						height="100px"></td>
					<td><a href="${path}/admin/project_detail/${ad.pro_id}">
							${ad.pro_name}</a></td>
					<td><a href="${path}/admin/mem_view/${ad.maker_idx}">
							${ad.maker_name}</td>
					<td><fmt:parseDate var="parseDate" value="${ad.pro_start}"
					                    pattern="yyyy-MM-dd"/>
					<fmt:formatDate value="${parseDate}"
					                    pattern="yyyy-MM-dd"/> </td>
					<td><c:choose>
							<c:when test="${ad.pro_status == '2'}">승인대기</c:when>
							<c:when test="${ad.pro_status == '3'}">오픈예정</c:when>
							<c:when test="${ad.pro_status == '4'}">진행</c:when>
							<c:when test="${ad.pro_status == '5'}">마감</c:when>
						</c:choose></td>
				</tr>
			</c:forEach>
	</table>
</center>
</body>
</html>