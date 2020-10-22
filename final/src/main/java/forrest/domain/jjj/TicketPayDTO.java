package forrest.domain.jjj;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketPayDTO {
		
	Integer payPrice;
	String memId;
	String payWay;
	
}
