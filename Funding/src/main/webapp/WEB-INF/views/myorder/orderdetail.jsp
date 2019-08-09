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
<form>
<input type="button" value="나의 리워드">
<h2>주문정보</h2>
<p> 주문번호: ${orderinfo.order_id} </p>
<p> 주문날짜: ${orderinfo.order_date} </p>
<h2>프로젝트정보</h2>
<p> 프로젝트 종료일: ${proinfo.pro_end} </p>
<p> 프로젝트 이름:  ${proinfo.pro_name} </p>
<h2>메이커정보</h2>
<p> 메이커 이름: ${meminfo.mem_name } </p>
<h2>배송정보</h2>
<p> 주문자 이름: ${shipinfo.order_name} </p>
<p> 주문자 전화번호: ${shipinfo.order_phone} </p>
<p> 주문자 배송요청: ${shipinfo.order_requests} </p>
<p> 배송상태: ${shipinfo.order_status} </p>
<p> 배송주소1: ${shipinfo.order_address1} </p>
<p> 배송주소2: ${shipinfo.order_address2} </p>
<p> 배송주소3: ${shipinfo.order_address3} </p>
<p> 배송주소4: ${shipinfo.order_address4} </p>
<h2>리워드</h2>
<c:forEach items="${rewardinfo}" var="rewards">
<p> 리워드번호: ${rewards.reward_id}</p>
<p> 리워드제목: ${rewards.reward_title}</p>
<p> 리워드설명: ${rewards.reward_description}</p>
<p> 리워드가격: ${rewards.reward_price}</p>
<p> 리워드옵션: ${rewards.reward_option_detail}</p>
</c:forEach>
</form>
</body>
</html>