package forrest.controller.jjj;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jjj.ticket.SearchCommand;
import forrest.command.jjj.ticket.TicketOrderCommand;
import forrest.service.jjj.ticket.TicketListService;
import forrest.service.jjj.ticket.TicketOrderService;
import forrest.service.sy.PointService;

@Controller
@RequestMapping("dogVillage")
public class DogVillageMainController {

	@Autowired
	TicketListService ticketListService;
	@Autowired
	TicketOrderService ticketOrderService;
	@Autowired
	PointService pointService;
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String dvlMain() {
		return "thymeleaf/frontPage/html/jjj/dvlMain";
	}
	@RequestMapping(value = "searchTicket", method = RequestMethod.POST)
	public String ticketSearch(@RequestParam(value ="ticketSeason")String ticketSeason , Model model , SearchCommand command) {
		ticketListService.listTicket(model,command);
		model.addAttribute("ticketSeason",ticketSeason);
		return "thymeleaf/frontPage/html/jjj/dvlticketList";
	}
	@RequestMapping(value = "ticketOrder", method = RequestMethod.POST)
	public String ticketRegist(TicketOrderCommand command, Model model, HttpSession session) {
		ticketOrderService.insertTicketOrder(command, model);
		pointService.selectPointSum(session, model);
		return "thymeleaf/frontPage/html/jjj/dvlticketOrder";
	}
	@RequestMapping(value = "ticketOrderPro", method = RequestMethod.POST)
	public String ticketOrderPro(TicketOrderCommand command, Model model) {
		
		return "";
	}
}
