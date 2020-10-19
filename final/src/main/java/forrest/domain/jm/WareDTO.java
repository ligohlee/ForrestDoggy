package forrest.domain.jm;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WareDTO {
	Integer wareNum;
	Integer goodsNum;
	Integer wareQty;
	Timestamp wareRegist;
	String goodsName;
	String ptName;
	String ptType;
	String goodsCategory;
	String goodsMade;
}
