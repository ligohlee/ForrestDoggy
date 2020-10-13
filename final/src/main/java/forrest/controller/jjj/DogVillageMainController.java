package forrest.controller.jjj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.service.jjj.ticket.TicketListService;

@Controller
@RequestMapping("dogVillage")
public class DogVillageMainController {

	@Autowired
	TicketListService ticketListService;
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String dvlMain() {
		return "thymeleaf/frontPage/html/jjj/dvlMain";
	}
	@RequestMapping(value = "searchTicket", method = RequestMethod.POST)
	public String ticketSearch(Model model) {
		ticketListService.listTicket(model);
		return "thymeleaf/frontPage/html/jjj/dvlticketList";
	}
	@RequestMapping(value = "ticketRegist", method = RequestMethod.GET)
	public String ticketRegist() {
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_backTicketRegi";
	}
}
