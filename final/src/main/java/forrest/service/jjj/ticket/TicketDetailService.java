package forrest.service.jjj.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jjj.TicketDTO;
import forrest.mapper.jjj.TicketMapper;

@Service
@Component
public class TicketDetailService {
	@Autowired
	TicketMapper mapper;
	public void selectTicket(int ticketNum, Model model) {
		TicketDTO ticketNum1 = new TicketDTO();
		ticketNum1.setTicketNum(ticketNum);
		TicketDTO dto = mapper.selectTicket(ticketNum1);
		model.addAttribute("ticket",dto);
	}

}
