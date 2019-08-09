<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>navbar</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	margin: 0;
}

ul.topnav {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

ul.topnav li {
	float: left;
}

ul.topnav li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

ul.topnav li a:hover:not (.active ) {
	background-color: #111;
}

ul.topnav li a.active {
	background-color: #ff6347;
}

ul.topnav li.right {
	float: right;
}

@media screen and (max-width: 600px) {
	ul.topnav li.right, ul.topnav li {
		float: none;
	}
}
</style>
</head>
<body>
<center><img src="images/crife.png" alt="crife" width="200" height="100"></center>
	<ul class="topnav">
		<li><a class="active" href="${path}/">Home</a></li>
		<li><a href="${path}/project/listv">프로젝트 더보기</a></li>
		<li><a href="${path}/community/notice/notice.do">공지사항</a></li>
		<li><a href="${path}/community/qna/qna.do">Q&A</a></li>
		<li><a href="${path}/admin/adminhome.do">관리자</a></li>
		<li class="right"><a href="${path}/project/check">펀딩오픈신청</a></li>
		<c:if test="${sessionScope.login == null}">
			<li class="right"><a href="${path}/user/login">로그인</a></li>
			<li class="right"><a href="${path}/user/join">회원가입</a></li>
		</c:if>
		<c:if test="${sessionScope.login != null}">
			<li class="right"><a href="${path}/user/logout">로그아웃</a></li>
			<li class="right"><a href="${path}/project/my_pro">내 프로젝트 목록</a></li>
		</c:if>
	</ul>
</body>
</html>