<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%@ include file="../include/header.jsp"%>
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
	
<!-- Bootstrap core CSS
<link href="../css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 Custom styles for this template -->

</head>

<a class="nav-link active" href="${path}/">Home</a>

<body>
<style>
body {background: #FAFAFA;}
table{width: 500px;}
tr, td {width:300px;} 
.login_box {
    position:absolute; 
    top:50%; left:50%;
    margin-top:-100px; margin-left:-100px; 
    width:500px; height:200px; 
    }
.login_box input[type="text"]{width: 250px;}
.login_box input[type="password"]{width: 250px;}
.btnLogin{
}
</style>
<div class="login_box">

	<form name="adLogin" id="adLogin" method="post">
		<table>
		    <tr>
		    <td><h4>관리자 로그인</h4></td>
		    </tr>
			<tr>
				<td><input type="text" name="admin_id" placeholder="아이디"></td>
			</tr>
			
			<tr>
				<td><input type="password" name="admin_pw" placeholder="비밀번호"></td>
			</tr>
			<td>
			<input type="button" id="btnLogin" value="로그인">
				<c:if test="${param.message=='error'}">아이디 또는 비밀번호가 일치하지 않습니다. 
				</c:if> 
                <c:if test="${messagge=='logout'}">로그인 시간이 만료되었습니다. 
                </c:if>
            </td>
		</table>
	</form>
	</div>
</body>
<script>
$(function() {
	$("#btnLogin").click(function() {
		var admin_id=$("#admin_id").val();
		var admin_pw=$("#admin_pw").val();
		
		if(admin_id==""){
			alert("아이디를 입력하세요.");
			$("#admin_id").focus();
			return;
		}
		if(admin_pw==""){
			alert("비밀번호를 입력하세요.");
			$("#admin_pw").focus();
			return;
		}
		document.adLogin.action="${path}/admin/loginCheck.do";
		document.adLogin.submit();	
	});
});

</script>
</html>