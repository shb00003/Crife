<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="${path}/">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${path}/community/notice/notice.do">공지사항</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${path}/community/qna/qna.do">Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${path}/admin/adminhome.do">관리자</a>
  </li>
</ul>
<ul class="nav justify-content-end">
	 <c:if test="${not empty login}">
	<p>${login.mem_name }님  로그인했음</p>
		<li class="nav-item"><a class="nav-link" href="<c:url value='/user/logout'/>" >로그아웃</a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value='/user/myinfo?mem_idx=${login.mem_idx}'/>" >내정보</a></li>
	<c:choose>
		<c:when test="${empty maker_idx }">
			<li class="nav-item"><a class="nav-link" href="<c:url value='/maker/maker?mem_idx=${login.mem_idx }'/>" > 메이커 등록</a></li>
		</c:when>
		<c:when test="${not empty maker_idx }">
			<a class="nav-link" href="<c:url value='/maker/makerinfo?mem_idx=${login.mem_idx }'/>" >메이커 정보</a>
		</c:when>
	</c:choose>
	</c:if>
	<c:choose>
	<c:when test="${empty login}">
		<li class="nav-item"><a class="nav-link active" href="<c:url value='/user/login'/>">로그인</a></li>
		<li class="nav-item"><a class="nav-link active" href="<c:url value='/user/join'/>" >회원가입</a></li>
	</c:when>

	</c:choose>
</ul>