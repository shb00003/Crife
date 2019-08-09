<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap 적용 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="../include/navbar.jsp"%>
<br>
<a href="${path}/admin/managerList.do">관리자 리스트</a> |

	<form name="adLogin" method="post">
		<table>
			<tr>
				<td><input type="text" name="ad_id" placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input type="password" name="ad_pw" placeholder="비밀번호"></td>
			</tr>
			<td colspan="2"><input type="button" id="adLogbtn" value="로그인">
				<%-- <c:if test="${param.message=='error'}">
                     아이디 또는 비밀번호가 일치하지 않습니다. </c:if> 
                <c:if test="${messagge=='logout'}">
                     로그인 시간이 만료되었습니다. </c:if> --%>
            </td>
		</table>
	</form>
</body>
</html>
