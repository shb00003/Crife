<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <%@ include file="../include/header.jsp"%>
</head>
<body>
<%@ include file="../include/navbar.jsp"%>
<%@ include file="project_navbar.jsp"%>
	<br>소개 영상<br>
	유튜브 동영상 주소를 적어주세요<br>
	<iframe width="640" height="360" src="${detail.pro_video}"
	frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe><br>
	간단설명<br>
	프로젝트에 대한 간단한 설명을 해주세요<br>
	${detail.pro_summary}<br>
	스토리<br>
 	${detail.pro_content}<br>
 <form name="story_form" method="post" action="${path}/project/story/update">
 	<input type="hidden" name="pro_id" value="${detail.pro_id}">
 	<input type="button" value="수정하기" id='update' >
 </form>
</body>
<script>
	$(document).ready(function() {
		$('#update').click(function() {
			document.story_form.submit();
		});
	});
</script>
</html>