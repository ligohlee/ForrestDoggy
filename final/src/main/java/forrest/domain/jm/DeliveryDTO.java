package forrest.domain.jm;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {
	Integer dyNum;
	Integer orderNum;
	Integer ptNum;
	Integer ctNum;
	Timestamp dyRegist;
	Integer dyPrice;
	String dyMemName;
	String dyMemAddr;
	
	
	
}
