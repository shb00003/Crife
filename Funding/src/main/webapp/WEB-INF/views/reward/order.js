// 수량 감소 증가 

$(function() {
		$('.decreaseQuantity').click(function(e) {
			e.preventDefault();
			var btn = $(e.target.parentNode);
			/* console.log(btn.children('#numberUpDown').text());
			console.log(btn); */
			var stat = btn.children('.numberUpDown').val();
			var num = parseInt(stat, 10);
			num--;
			if (num <= 0) {
				alert('더이상 줄일수 없습니다.');
				num = 1;
			}
			btn.children('.numberUpDown').val(num);
		});
		$('.increaseQuantity').click(function(e) {
			e.preventDefault();
			var btn = $(e.target.parentNode);
			var stat = btn.children('.numberUpDown').val();
			var num = parseInt(stat, 10);
			num++;

			if (num > 5) {
				alert('더이상 늘릴수 없습니다.');
				num = 5;
			}
			btn.children('.numberUpDown').val(num);
		});
	});