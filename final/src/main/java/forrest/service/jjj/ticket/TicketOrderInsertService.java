package forrest.service.jjj.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.ticket.TicketOrderCommand;
import forrest.domain.jjj.TicketOrderDTO;
import forrest.mapper.jjj.TicketOrderMapper;

@Service
@Component
public class TicketOrderInsertService {
	
	@Autowired
	TicketOrderMapper mapper;

	public void insertOrder(TicketOrderCommand command) {
		// TODO Auto-generated method stub
		TicketOrderDTO dto = new TicketOrderDTO();
		dto.setMemId(command.getMemId());
		mapper.insertOrder(dto);
		
		int a = command.getTicketNum().length;
		for (int i = 0; i < a; i++) {
			
				dto.setTicketNum(command.getTicketNum()[i]);
				dto.setTolistQty(command.getTolistQty()[i]);
				dto.setMemId(command.getMemId());
				dto.setTorderPrice(command.getTorderPrice());
				mapper.insertOrderList(dto);
		
			
		}
		
	}

}
