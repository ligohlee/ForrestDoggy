package forrest.service.jjj.ticket;

import java.sql.Timestamp;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.ticket.TicketCommand;
import forrest.domain.jjj.TicketDTO;
import forrest.mapper.jjj.TicketMapper;

@Service
@Component
public class TicketModifyService {
	@Autowired
	TicketMapper mapper;
	public void modifyTicket(int ticketNum, TicketCommand command) {
		
		TicketDTO dto = new TicketDTO();
		dto.setTicketNum(ticketNum);
		dto.setTicketName(command.getTicketName());
		
		dto.setTicketTime(command.getTicketTime());
		dto.setTicketPrice(command.getTicketPrice());
		dto.setTicketGrade(command.getTicketGrade());
		dto.setTicketQty(command.getTicketQty());
		
		mapper.updateTicket(dto);
	}

}
