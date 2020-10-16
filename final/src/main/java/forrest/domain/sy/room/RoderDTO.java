package forrest.domain.sy.room;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoderDTO {
	
	Integer roNum;
	String memId;
	Integer roomNum;
	Timestamp roRegist;
	String roName;
	String roPh;
	Timestamp checkIn;
	Timestamp checkOut;
	String roReq;

	
}
