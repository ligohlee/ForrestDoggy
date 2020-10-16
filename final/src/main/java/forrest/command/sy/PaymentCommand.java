package forrest.command.sy;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCommand {
	
	Integer payPrice;
	String payWay;

}
