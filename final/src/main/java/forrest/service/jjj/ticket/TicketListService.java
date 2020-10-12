package forrest.service.jjj.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jjj.TicketDTO;
import forrest.mapper.jjj.TicketMapper;


@Service
@Component
public class TicketListService {
	@Autowired
	TicketMapper ticketMapper;
	
	public void listTicket(Model model) {
		List<TicketDTO> list = ticketMapper.selectTicketAll();
		model.addAttribute("list" , list);
	}

}
