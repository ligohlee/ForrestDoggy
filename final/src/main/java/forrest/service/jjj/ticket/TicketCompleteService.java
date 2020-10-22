package forrest.service.jjj.ticket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.jjj.ticket.TicketOrderCommand;
import forrest.domain.jjj.TicketOrderDTO;
import forrest.mapper.jjj.TicketOrderMapper;

@Service
@Component
public class TicketCompleteService {
	
	@Autowired
	TicketOrderMapper mapper;

	public void selectTorder(TicketOrderCommand command, Model model) {
		// TODO Auto-generated method stub
		TicketOrderDTO dto = new TicketOrderDTO();
		dto.setMemId(command.getMemId());
		
		List<TicketOrderDTO> list = new ArrayList<TicketOrderDTO>();
		list = mapper.selectNowOrder(dto);
		model.addAttribute("nowList", list);
		System.out.println(list);
	}

}
