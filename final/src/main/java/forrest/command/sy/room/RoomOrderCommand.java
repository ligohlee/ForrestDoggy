package forrest.command.sy.room;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RoomOrderCommand {
	
	// 객실 주문서에서 입력받을 정보
	
	String memId;
	
	Integer roomNum;
	
	String roName;
	String roPh;
	
	Date checkIn;
	String checkOut;
	
	String roReq;

}
