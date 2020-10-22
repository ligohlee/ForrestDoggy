package forrest.domain.jjj;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOrderDTO {
	
	Integer torderNum; 
	Integer ticketNum; 
	Integer torderPrice; 
	Integer tolistQty; 	
	String memId;
	
	
	String ticketName;
	Timestamp ticketSeason;
	String ticketTime;
	String ticketGrade;

	
	
}
