package forrest.service.jjj.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.mapper.jjj.TicketMapper;

@Service
@Component

public class TicketDeleteService {
	@Autowired
	TicketMapper mapper;
	public void deleteTicket(int ticketNum) {
		
		mapper.deleteTicket(ticketNum);
	}
	
}
