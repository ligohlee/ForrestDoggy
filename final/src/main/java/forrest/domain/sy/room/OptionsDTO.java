package forrest.domain.sy.room;




import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionsDTO {
	
	    
	private Integer optNum;
	private String optName;
	private Integer optPrice;
	private Timestamp optRegist;
	
	private List<RoptionsDTO> roptions;
	

}
