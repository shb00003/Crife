<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<style>
/* 가운데 정렬 */
.page{	
	display: flex;
	justify-content : center;
	align-items: center;
}
</style>
<script>
function list(page) {
	location.href="${path}/community/notice/notice.do?curPage="+page
			+"&search_option=${map.search_option}"
			+"&keyword=${map.keyword}";
}
</script>
<div class="page">
<nav aria-label="Page navigation example">
	<ul class="pagination">
	<c:if test="${map.pager.curBlock > 1 }">
		<li class="page-item"><a class="page-link" href="javascript:list('1')" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
		&nbsp;
	</c:if>
	<c:if test="${map.pager.curBlock > 1 }">
		<li class="page-item"><a class="page-link" href="javascript:list('${map.pager.blockBegin}')" aria-label="Previous"> <span aria-hidden="true">이전</span></a></li>
		&nbsp;
	</c:if>
	<c:forEach var="num" begin="${map.pager.blockBegin}" end="${map.pager.blockEnd}">
		<c:choose>
			<c:when test="${num==map.pager.curPage}">
				<li class="page-item"><span class="page-link" style="color:red;">${num}</span></li>&nbsp;
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="javascript:list('${num}')">${num}</a></li>&nbsp;
			</c:otherwise>
		</c:choose>
		
<!-- 		<li class="page-item"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<a href="javascript:list('${num}')">${num}</a>&nbsp;
		<li class="page-item"><a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li> -->
	</c:forEach>
	<c:if test="${map.pager.curBlock <= map.pager.totBlock}">
		<li class="page-item"><a class="page-link" href="javascript:list('${map.pager.nextPage}')" aria-label="Next"> <span aria-hidden="true">다음</span></a></li>
		&nbsp;
	</c:if>
	<c:if test="${map.pager.curPage <= map.pager.totPage}">
		<li class="page-item"><a class="page-link" href="javascript:list('${map.pager.totPage}')" aria-label="End"> <span aria-hidden="true">&raquo;</span></a></li>
	</c:if>
	</ul>
</nav>
</div>