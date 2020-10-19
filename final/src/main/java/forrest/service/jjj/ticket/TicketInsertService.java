package forrest.service.jjj.ticket;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.ticket.TicketCommand;
import forrest.domain.jjj.TicketDTO;
import forrest.mapper.jjj.TicketMapper;

@Service
@Component
public class TicketInsertService {
	
	@Autowired
	TicketMapper ticketMapper;
	
	public void insertTicket(TicketCommand command){
		
		TicketDTO dto = new TicketDTO();
			
		dto.setTicketName(command.getTicketName());
		dto.setTicketTime(command.getTicketTime());
		
		Timestamp ticketSeason = new Timestamp(command.getTicketSeason().getTime());
		dto.setTicketSeason(ticketSeason);
		
		dto.setTicketGrade(command.getTicketGrade());
		dto.setTicketPrice(command.getTicketPrice());	
		dto.setTicketQty(command.getTicketQty());
		ticketMapper.insertTicket(dto);
		
		

	}

}
