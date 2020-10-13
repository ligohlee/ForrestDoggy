package forrest.domain.jm;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {
	Integer goodsNum;
	Integer ctNum;
	Integer ptNum;
	String ptName;
	String goodsName;
	Integer goodsPrice;
	String goodsCategory;
	String goodsMade;
	String goodsSize;
	String goodsManual;
	String goodsIntro;
	Timestamp goodsTimeLimit;	
	String goodsImg;
	
	
	
	
	
	
	
}
