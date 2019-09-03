<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" /> --%>
<%@ include file="../include/header.jsp" %> 

<script type="text/javascript">

</script>
<ul class="nav justify-content-center">
	<li class="nav-item"><a class="nav-link active" href="${path}/">Home</a>
	</li>
	<li class="nav-item" id="ad_home"><a class="nav-link"
		href="${path}/admin/adminhome.do">관리자 홈</a></li>
	<li class="nav-item" id="ad_mem"><a class="nav-link"
		href="${path}/admin/memListGET.do">회원정보</a></li>
	<li class="nav-item" id="ad_pro"><a class="nav-link"
		href="${path}/admin/projectList.do">프로젝트 목록</a></li>
	<li class="nav-item" id="manager"><a class="nav-link"
		href="${path}/admin/managerList.do">관리자 목록</a></li>
</ul>
	<c:if test="${sessionScope.admin_id!=null}">
	${sessionScope.admin_name}님이 로그인 중입니다.
    <a href="${path}/admin/logout.do">로그아웃</a></li>
	</c:if>
