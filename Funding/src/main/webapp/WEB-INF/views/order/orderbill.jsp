<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/script.jsp"%>

<meta charset="UTF-8">
<title>order 완료 화면입니다.</title>
</head>
<body>
<form method="get">
<input type="hidden" name="mem_idx" value="2">
<a href="${path}/mypage/myorder/orderlist?pro_id=2">결제내역으로 이동하기</a>
</form>
</body>
</html>