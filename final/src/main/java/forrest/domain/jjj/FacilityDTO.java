package forrest.domain.jjj;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDTO {
	Integer facNum;   
	String facName;
	String facInfo;
	String facImg;
	Timestamp facRegist;
	}


