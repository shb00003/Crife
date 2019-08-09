<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/script.jsp"%>

<meta charset="UTF-8">
<title>Myorder 결제내역 보기</title>
</head>
<body>
<form >
<input type="button" value="나의 리워드">


<table>
<tr>
<td> 프로젝트 이름  </td>
<td> 카테고리 </td>
<td> 메이커 이름  </td>
<td> 주문번호 </td>
</tr>
<c:forEach items="${rewardList}" var="rewardlist">
<tr>
	<td><a href="${path}/mypage/myorder/orderdetail?order_id=${rewardlist.order_id}">${rewardlist.pro_name}</a></td>
	<td>${rewardlist.pro_category }</td>
	<td>${rewardlist.mem_name}</td>
	<td>${rewardlist.order_id}</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>