package forrest.domain.jm;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GOrderDTO {
	Integer gorderNum;
	String memId;
	Timestamp gorderRegist;
	Integer goodsNum;
	Integer gorderPrice;
	Integer gorderQty;
	
}
