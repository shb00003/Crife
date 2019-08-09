<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script src="<c:url value='/webjars/jquery/3.4.1/dist/jquery.min.js' />"></script>
<script type="text/javascript">

	var result = confirm("메이커 정보를 삭제 하시겠습니까?");

	if(result){
		self.location='<c:url value="/"/>';
	}else{
		history.back();
	}

</script>