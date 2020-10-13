package forrest.domain.jm;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class COrderDTO {
	Integer cordNum;
	Integer goodsNum;
	String goodsName;
	Integer cordQty;
	Timestamp cordRegist;
	
	
	
	
	
}
