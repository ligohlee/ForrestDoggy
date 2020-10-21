package forrest.domain.ligoh;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MorderDTO {
	
	Integer mordNum;
	String memId;
	Integer mordPeople;
	Integer mordTable;
	Integer[] courseNum;
	Timestamp mordDate;
	String menuReq;
	
	
}
