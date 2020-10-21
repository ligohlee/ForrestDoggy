package forrest.domain.sy.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectOptionDTO {
	
	Integer selNum;
	Integer roNum;
	
	String selName;
	Integer selQty;
	Integer selPrice;
	
	String memId;

}
