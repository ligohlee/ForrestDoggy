package forrest.domain.sy;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointDTO {
	
	String memId;
	String pointIn;
	String pointOut;
	Timestamp pointRegist;
	String pointSum;

	
}
