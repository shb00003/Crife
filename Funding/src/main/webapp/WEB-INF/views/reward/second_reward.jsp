<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/script.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <!--멤버 나중에 받아야함.  -->
        
<form role="form" method="post" action="${path}/order/reservation">
		<input type="hidden" name="mem_idx" value="2">
<table>
	<!--tr아래에 선언해야 total이 0으로 초기화가 되지 않음.  -->
	<c:set var="total" value="0" />
	<tr>
		<td>리번</td>
		<td>리워드 제목</td>
		<td>리수량</td>
		<td>리합산</td>
	</tr>
	<c:forEach items="${rewardSel.list}" var="reward2">
		<c:if test="${reward2.reward_id != 0}">
			<tr>
				<td>
				<input type="hidden"  class="select_count" value="${reward2.reward_id}">
				<input type="hidden"  id="qty${reward2.reward_id}" value="${reward2.qty}">
				<input type="hidden"  id="pro_id${reward2.reward_id}" value="${reward2.pro_id}">
				</td>
				<td>${reward2.reward_id}</td>
				<td>${reward2.reward_title}</td>
				<td>${reward2.qty}</td>
				<td>${reward2.sumAmount}</td>
			</tr>
			<c:set var="total" value="${total + reward2.sumAmount}"/>
		</c:if>
	</c:forEach>
	<tr>
		<td>후원금:  ${rewardSel.addDonation}</td>
		<td>총 가격: <fmt:formatNumber pattern="###,###,###" value= "${total+rewardSel.addDonation}" /><span>원 </span></td>
	</tr>
	<tr>
</table>
<p>펀딩 서포터 </p>

<p> 이름 : ${pinfo.mem_name} </p>
<p> 이메일 : ${pinfo.mem_email} </p>
<p> 휴대폰번호 : ${pinfo.mem_phone} </p>

<br>
<p> 최근 주문 주소지 </p>
이름 : <input type="text" value="${orderInfo.order_name}" readOnly>  
전번 : <input type="text" value="${orderInfo.order_phone}" readOnly>  
<br>
주소 : <input type="text" value="${orderInfo.order_address_all}" readOnly>  
<p>-----------------------------------------------------------------------</p>
<p>새로운 주소지</p>
이름 : <input type="text" name="order_name" id="order_name_js"> 	
전화번호 : <input type="text" name="order_phone" id="order_phone_js"> 
이메일 : <input type="text" name="order_email" id="order_phone_js"> 
<br><br>	

<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="d_btn">
<br>
<input type="hidden" name="order_address1" id="sample4_postcode"  placeholder="우편번호">
<input type="hidden" name="order_address2" id="sample4_roadAddress"  placeholder="도로명주소">
<input type="hidden" name="order_address3" id="sample4_jibunAddress"  placeholder="지번주소">

<textarea id="home_address" rows="2" cols="30" readonly></textarea> 
<br>
<input type="text" name="order_address4" id="order_address4" class="d_form" placeholder="상세주소">

<br>
<br>
<input id="rbtn" type="button" value="결제예약하기"/>
</form>
</body>

<script>
$(document).ready(function() {
	/*  method="post" action="${path}/order/reservation"  */
 	var formObj = $("form[role='form']");
	console.log(formObj);
	$("#rbtn").on("click", function() {
		rewardNextStep();
		formObj.submit();
	});
	
	function rewardNextStep() {
        $('.select_count').each(function(idx) {
            var rewardId = $(this).val();
            var qty = $('#qty' + rewardId).val();
   		    var pro_id = $('#pro_id' + rewardId).val();
			// 한번에 저장하기 위해 name을 배열로 전달한다. 
            $('[role="form"]').append('<input type="hidden" name="orderList[' + idx + '].reward_id" value="' + rewardId + '" />');
            $('[role="form"]').append('<input type="hidden" name="orderList[' + idx + '].order_count" value="' + qty + '" />');
            $('[role="form"]').append('<input type="hidden" name="orderList[' + idx + '].pro_id" value="' + pro_id + '" />');
        });
    }
});
</script>


<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress; 
                document.getElementById("home_address").value = data.zonecode +" "+ roadAddr +" "+ data.jibunAddress; 
                
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
               /*  if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                } */
            }
        }).open();
    }
</script>
</html>