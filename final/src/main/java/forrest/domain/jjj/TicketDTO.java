package forrest.domain.jjj;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
	Integer ticketNum;   
	String ticketName;
	Timestamp ticketSeason;
	String ticketTime;
	String ticketGrade;
	Integer ticketPrice;	   
	String ticketRegist;
	Integer ticketQty;

	}

