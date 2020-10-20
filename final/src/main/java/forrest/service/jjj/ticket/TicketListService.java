package forrest.service.jjj.ticket;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.jjj.ticket.SearchCommand;
import forrest.domain.jjj.TicketDTO;
import forrest.mapper.jjj.TicketMapper;


@Service
@Component
public class TicketListService {
	@Autowired
	TicketMapper ticketMapper;
	
	public void listTicket(Model model, SearchCommand command) {
		TicketDTO dto = new TicketDTO();
		Timestamp ticketSeason = new Timestamp(command.getTicketSeason().getTime());
	
	
		dto.setTicketSeason(ticketSeason);
		List<TicketDTO> list = ticketMapper.selectTicketAll(dto);
		model.addAttribute("list" , list);
	}
	
	public void listTicketBack(Model model) {
		
		List<TicketDTO> list = ticketMapper.selectTicketAll(null);
		model.addAttribute("list" , list);
	}

}
