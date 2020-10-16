package forrest.domain.sy;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
	
	Integer payNum;
	Timestamp payDate;
	Integer payPrice;
	String payWay;
	String refund;
	

}
