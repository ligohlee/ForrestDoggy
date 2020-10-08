package forrest.command.jjj.ticket;





import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCommand {
	
		
		String ticketName;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		Date ticketSeason;
		
		String ticketTime;
		String ticketGrade;
		Integer ticketPrice;	   		
		Integer ticketQty;
}



