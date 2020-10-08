package forrest.controller.jjj.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.command.jjj.ticket.TicketCommand;
import forrest.service.jjj.ticket.TicketInsertService;

@Controller
@RequestMapping("dvlback")
public class DogVillageBackTicketController {
	@Autowired
	TicketInsertService ticketInsertService;
	
	@RequestMapping(value = "ticketList", method = RequestMethod.GET)
	public String ticketList() {
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_backTicket";
	}
	@RequestMapping(value = "ticketRegist", method = RequestMethod.GET)
	public String ticketRegist() {
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_backTicketRegi";
	}
	@RequestMapping(value = "ticketRegistPro", method = RequestMethod.POST)
	public String ticketRegistPro(TicketCommand command){
		ticketInsertService.insertTicket(command);
		return "redirect:/dvlback/ticketList";
	}
}

