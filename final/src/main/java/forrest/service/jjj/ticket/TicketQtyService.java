package forrest.service.jjj.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.ticket.TicketOrderCommand;
import forrest.domain.jjj.TicketOrderDTO;
import forrest.mapper.jjj.TicketMapper;

@Service
@Component
public class TicketQtyService {
	
	@Autowired
	TicketMapper mapper;
	public void updateQty(TicketOrderCommand command) {
		// TODO Auto-generated method stub
		
		TicketOrderDTO dto = new TicketOrderDTO();
		int a = command.getTicketNum().length;
		for (int i = 0; i < a; i++) {
			
			dto.setTicketNum(command.getTicketNum()[i]);
			dto.setTolistQty(command.getTolistQty()[i]);
			mapper.updateQty(dto);
			
		}
		
	}

}
