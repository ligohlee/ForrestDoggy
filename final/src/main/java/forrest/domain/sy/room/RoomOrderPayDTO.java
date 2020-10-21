package forrest.domain.sy.room;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomOrderPayDTO {
	
	Integer roomNum;
	Timestamp checkIn;
	Timestamp checkOut;
	Integer payPrice;

}
