package forrest.command.sy.room;


import lombok.Data;

@Data
public class RoomReservationInfoCommand {
	
	//객실상세페이지->주문서 페이지로 전달되는 정보
	
	
	String checkIn;
	String checkOut;	
	Integer optNum[]; //객실주문서에 선택한 옵션 정보 출력하기 위해 가져감
	Integer selQty[]; //객실주문서에 선택한 옵션의 수량 출력하기 위해 가져감
	String optName[];
	Integer optTotalPrice[];
	
	
	
	
	
}
