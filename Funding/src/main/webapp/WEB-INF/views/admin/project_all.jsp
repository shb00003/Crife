<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<br>
	<%@ include file="../include/navbar.jsp"%>
<table><tr><td height="30px"></td></tr></table>
<br>
<table align="center">
<td height="" valign="buttom">
 <select name="proList" id="proList">
 <option value="pro_name">프로젝트명</option>
 <option value="pro_idx">프로젝트 번호</option>
 <option value="maker_name">메이커명</option>
 <option value="maker_idx">메이커 번호</option>
 </select></td>
<td><input type="text" neme="pro_search" id="pro_search"></td>
<td>
<input type="button" name="pro_bnt1" value="조회">
</td>
</tr>
</table>
<table border="1" >
<tr>
<td>No</td>
<td colspan="2">프로젝트명</td>
<td>메이커</td>
<td>프로젝트 시작일</td>
<td>상태</td>
<c:forEach var="ad" items="${list}">
<%-- <c:if test="${ad.pro_type_progress != '1'}"> --%>
<tr>
<td>${ad.pro_idx}</td>
<td><img src="${path}/images/${ad.pro_image}"
         width="100px" height="100px"></td>
<%-- <td><img src="${path}/images/${ad.pro_image}"
         width="100px" height="100px"></td> --%>
<td><a href="${path}/admin/project_detail/${ad.pro_idx}">
       ${ad.pro_name}</a></td>
<td><a href="${path}/admin/mem_view/${ad.maker_idx}">
       ${ad.maker_name}</a></td>
<td><fmt:formatDate value="${ad.pro_start}" pattern="yyyy-MM-dd"/></td>
<td><c:choose>
         <c:when test="${ad.pro_type1 == '2'}">승인대기</c:when>
         <c:when test="${ad.pro_type1 == '3'}">오픈예정</c:when>
         <c:when test="${ad.pro_type1 == '4'}">진행</c:when>
         <c:when test="${ad.pro_type1 == '5'}">마감</c:when>
         </c:choose></td>
</tr>
</c:forEach>
</table>
</body>
</html>