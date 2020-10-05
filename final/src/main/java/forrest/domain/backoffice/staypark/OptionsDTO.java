package forrest.domain.backoffice.staypark;




import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionsDTO {
	
	    
	Integer optNum;
	String optName;
	Integer optPrice;
	Timestamp optRegist;
	

}
