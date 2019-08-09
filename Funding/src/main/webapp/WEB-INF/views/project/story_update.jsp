<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<head>
<!-- summernote -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<!-- include summernote-ko-KR -->
<script src="${path}/resources/summernote/lang/summernote-ko-KR.js"></script>
<style type="text/css">
   #pro_summary {
   	resize: none;
  	width: 400px;
  	height: 100px;
   }
</style>
</head>
<body>
<form name="story_form" method="post" action="${path}/project/story/detail"
	enctype="multipart/form-data">
	소개 영상<br>
	유튜브 동영상 주소를 적어주세요<br>
	<input type="text" name="pro_video" value="${detail.pro_video}" size="50"><br>
	간단설명<br>
	프로젝트에 대한 간단한 설명을 해주세요<br>
	<textarea id="pro_summary" name="pro_summary">${detail.pro_summary}</textarea><br>
 	스토리<br>
 	<textarea id="file2" name="file2">${datail.pro_content}</textarea>
 	<input type="hidden" name="pro_id" value="${detail.pro_id}">
 	<input type="button" value="저장하기" id='save3' >
 </form>
</body>
<script>
	$(document).ready(function() {
		
		$('#save3').click(function() {
			document.story_form.submit();
			alert("저장되었습니다");
		});
		
		$('#file2').summernote({
			lang : 'ko-KR', // default: 'en-US'
			tabsize : 2,
			width : 800,
			height : 500
		});
	});	
</script>
</html>