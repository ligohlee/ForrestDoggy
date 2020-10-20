package forrest.service.jjj.ticket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.jjj.ticket.TicketOrderCommand;
import forrest.domain.jjj.TicketDTO;
import forrest.mapper.jjj.TicketMapper;

@Service
@Component
public class TicketOrderService {
	@Autowired
	TicketMapper mapper;
	public void insertTicketOrder(TicketOrderCommand command, Model model) {
		// TODO Auto-generated method stub
		
		List<TicketDTO> list = new ArrayList<TicketDTO>();
		for (Integer num : command.getTicketNum()) {
			TicketDTO dto = new TicketDTO();
			dto.setTicketNum(num);
			list.add(mapper.selectTicket(dto));			
		}
		model.addAttribute("orderTicket", list);
		
	}

}
