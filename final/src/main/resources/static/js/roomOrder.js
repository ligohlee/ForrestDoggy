

$(document).ready(function(){
	
	
	// 객실가격*숙박일수
	var days = $('#days').val();
	alert("dkdk");
	var roomPrice = $('#roomPrice').val();
	var totalRoom = days*roomPrice;
	
	// 선택옵션 가격
	var optTotal=0;
	
	$("input[name=optTotal]").each(function(idx){
		
		  var optPrice = parseInt($(this).val());
		  if(isNaN(optPrice)){
			  optPrice=0;
		  }
		  optTotal=optTotal+optPrice;
                    	         
    });
	
	if(isNaN(optTotal)){
		optTotal=0;
		// alert(optTotal);
	}
	
	
	
	var totalPrice=totalRoom;
	alert(totalPrice);
	
	if(parseInt(optTotal) != 0){
		totalPrice=totalPrice+optTotal
		// alert("optTotal이 0이 아닐 때"+totalPrice);
	}
	
	
	
	
	$('#totalRoom').html(totalPrice+"원");
	$('#total').html("총 주문금액 "+totalPrice+"원");
	$('#prePayPrice').val(totalPrice);
	$('#payTotal').html(totalPrice);
	
	$("#memCheck").change(function(){
        if($("#memCheck").is(":checked")){
            $('#roName').val($('#memName').val());
            $('#roPh').val($('#memPh').val());
        }else{
        	$('#roName').val('');
            $('#roPh').val('');
        }
    });
	
	
	$('input[type="checkbox"][name="payWay"]').click(function(){
		if($('input[type="checkbox"][name="payWay"]').is(':checked')){			
			$('input[type="checkbox"][name="payWay"]').prop('checked',false);			
		}
		$(this).prop('checked',true);
	});
	
	$("#pointCheck").change(function(){
		if($("#pointCheck").is(":checked")){
			alert('되라');
		}
	}
	
	
	 $("#pointCheck").change(function(){
		
        if($("#pointCheck").is(":checked")){
        	
        	$('#usePoint').css('display','block');
        	var pointOut = parseInt($('#pointOut').val());
        	var nowPoint = parseInt($("#nowPoint").val());
        	if(isNaN(pointOut)){
        		pointOut=0;
    			$('#usePointBtn').click(function(){
    				alert("되냐?")
    				pointOut = parseInt($('#pointOut').val());
    				if(pointOut > nowPoint){
    					pointOut = 0;
    					alert("사용 가능한 포인트는 "+nowPoint+"점 입니다.");
    					$('#pointOut').val(pointOut);    					
    				}
    				$("#nowPoint").val(nowPoint-pointOut);
    				$('#payPoint').html(pointOut);
    				$('#payReal').html(totalPrice-pointOut)
    				$('#payPrice').val(totalPrice-pointOut);
    				
    			});    			
    		}	        		            
        }else{
        	
        	var pointOut = parseInt($('#pointOut').val());
        	var nowPoint = parseInt($("#nowPoint").val());
        	if(isNaN(pointOut)){
        		pointOut=0;
        		$("#nowPoint").val(nowPoint+pointOut);
        		
    		}
        	$("#nowPoint").val(nowPoint+pointOut);
        	$('#pointOut').val(0);
        	$('#usePoint').css('display','none');
   	
        
        }
    });
	
	
	if($('#usePoint').css('display','none')){
		$('#payPoint').html(0);
		$('#payReal').html(totalPrice);
		$('#payPrice').val(totalPrice);
		
		
	}
	
	 
	
	$('#rsvBtn').click(function(){
		if ($('input[type="checkbox"][name="payWay"]').is(':checked') == false) {
			  alert('결제수단을 체크하셔야 합니다.');
			  
		}else if($('#roName').val()== ''){
			alert('예약자 성함을 입력해주세요');
		}else if($('#roPh').val()== ''){
			alert('예약자 연락처를 입력해주세요');
		}else{
			$('#payPage').css('display','block');
			var payWay = $('input[type="checkbox"][name="payWay"]:checked').val();
			$('.payH2').html(payWay+" 결제");
			var pointIn = totalPrice*0.01;
			$('#payPointIn').html(pointIn);
			$('#pointIn').val(pointIn);
		}
		
	});
	
	$('#cancleBtn').click(function(){
		$('#payPage').css('display','none');
	});
	
	
	
	
	
	
	
	
	
	
});
