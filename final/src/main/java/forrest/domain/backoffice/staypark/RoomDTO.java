package forrest.domain.backoffice.staypark;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
	
	    
	Integer roomNum;
	String roomName;
	String roomInfo;
	Integer roomPrice;
	String roomImg;
	Integer capacity;
	Integer dogCap;
	Timestamp roomRegit;
	

}
