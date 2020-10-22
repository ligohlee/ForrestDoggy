
$(document).ready(function(){
	
	
		
		var qty=1;
		$('input[name="torderPrice"]').each(function(idx){
			var tPrice = parseInt($(this).val());			
			totalPrice = totalPrice + tPrice;
			
		});
		// 수량 체크 후 총 결제 가격 뽑기
		
		$("select[name='torderQty']").change(function(){
			qty = $(this).val();
			var tprice = $(this).siblings('input[name="tPrice1"]').val();
			var ttprice = qty*tprice;
			$(this).siblings('input[name="torderPrice"]').val(ttprice);
			
		});
		
		
		var totalPrice = 0;
		$('#qtybtn').click(function(){
			
			if(isNaN(totalPrice)){
				totalPrice = 0;
			}
			
			$('input[name="torderPrice"]').each(function(idx){
				var tPrice = parseInt($(this).val());			
				totalPrice = totalPrice + tPrice;
				
			});
			$('.totalPrice111').html("총 주문금액 "+totalPrice+"원");
			$('#torderPrice').val(totalPrice);
			$('#prePayPrice').val(totalPrice);
			$('#payTotal').html(totalPrice);
			$('#payPoint').html(0);
			$('#payPointIn').html(totalPrice*0.01);
			$('#payReal').html(totalPrice);
			$('#payPrice').val(totalPrice);
			
		});
		
		
		// 결제수단 하나만 체크되게 하기

		$('input[type="checkbox"][name="payWay"]').click(function(){
			if($('input[type="checkbox"][name="payWay"]').is(':checked')){			
				$('input[type="checkbox"][name="payWay"]').prop('checked',false);			
			}
			$(this).prop('checked',true);
		});
		
		
		// 포인트 사용하기 위해 체크박스 체크 시 이벤트

		$('input[type="checkbox"][name="point"]').change(function(){
			if($(this).is(':checked')){
				// 사용할 포인트 입력 input창 보이게
				$('#usePoint').css('display','block');
				$('#payPointIn').html(totalPrice*0.01);
				$('#payReal').html(totalPrice);
				$('#payPrice').val(totalPrice);
			}else{
				// 체크를 해지 했을 때 결제금액에서 빠졌던 포인트 금액을 다시 더해주고 0으로 만들어서 숨기기
				var ppoint = parseInt($('#pointOut').val());
				var ttotal = ppoint+totalPrice;
				$('.totalPrice111').html("총 주문금액 "+ttotal+"원");
				$('#prePayPrice').val(ttotal);
				$('#payTotal').html(ttotal);
				$('#pointOut').val(0);
				$('#payPoint').html(0);
				$('#payPointIn').html(ttotal*0.01);
				$('#usePoint').css('display','none');
				$('#payReal').html(ttotal);
				$('#payPrice').val(ttotal);
			}
		});
		
		// 사용할 포인트 입력하고 사용 버튼 눌렀을 때 해당 포인트만큼 결제 금액 마이너스 되게 & 가용 포인트보다 크게 적었을 때
		// 얼럿 창으로 가능한 포인트 안내 후 0으로 바뀌게
		var payWon;
		$('#usePointBtn').click(function(){
			var usePoint = parseInt($('#pointOut').val());
			if(usePoint> parseInt($('#nowPoint').val())){
				alert("현재 사용 가능한 포인트는 "+$('#nowPoint').val()+"점 입니다.");
				$('#pointOut').val(0);
				$('#payPoint').html(0);
			}else{
				payWon = totalPrice-usePoint;
				$('#prePayPrice').val(payWon);
				$('#payPoint').html(usePoint);
				$('#payReal').html(payWon);
				$('#payPointIn').html(payWon*0.01);
				$('#payReal').html(payWon);
				$('#payPrice').val(payWon);
				
			}			
			
		});


        
		$('#rsvBtn').click(function(){
			if ($('input[type="checkbox"][name="payWay"]').is(':checked') == false) {
				  alert('결제수단을 체크하셔야 합니다.');				  
			}else{
				var way = $("input:checkbox[name='payWay']:checked").val();
				$('.payH2').html(way+" 결제");
				$('#payPage').css('display','block');
			}
			
		});
		
		$('#cancleBtn').click(function(){
			$('#payPage').css('display','none');
		});
		

});
