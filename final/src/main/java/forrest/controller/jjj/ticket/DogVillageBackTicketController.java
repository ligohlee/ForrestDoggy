package forrest.controller.jjj.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jjj.ticket.TicketCommand;
import forrest.service.jjj.ticket.TicketDeleteService;
import forrest.service.jjj.ticket.TicketDetailService;
import forrest.service.jjj.ticket.TicketInsertService;
import forrest.service.jjj.ticket.TicketListService;
import forrest.service.jjj.ticket.TicketModifyService;

@Controller
@RequestMapping("dvlback")
public class DogVillageBackTicketController {
	@Autowired
	TicketInsertService ticketInsertService;
	@Autowired
	TicketListService ticketListService;
	@Autowired
	TicketDetailService ticketDetailService;
	@Autowired
	TicketModifyService ticketModifyService;
	@Autowired
	TicketDeleteService ticketDeleteService;
	
	@RequestMapping(value = "ticketList", method = RequestMethod.GET)
	public String ticketList(Model model) {
		ticketListService.listTicketBack(model);
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_backTicketList";
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
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "ticketDetail", method = RequestMethod.GET)
	public String roomDetail(@RequestParam(value="ticketNum") int ticketNum, Model model) {
		ticketDetailService.selectTicket(ticketNum, model);
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_backTicketDetail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "ticketModify", method = RequestMethod.GET)
	public String ticketModify(@RequestParam(value = "ticketNum") int ticketNum, Model model) {
		ticketDetailService.selectTicket(ticketNum,model);
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_backTicketModify";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "ticketModifyPro", method = RequestMethod.POST)
	public String ticketModifyPro(@RequestParam(value = "ticketNum") int ticketNum,TicketCommand command) {
		ticketModifyService.modifyTicket(ticketNum,command);
		return "redirect:/dvlback/ticketDetail?ticketNum="+ticketNum;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "ticketDelete", method = RequestMethod.GET)
	public String ticketDelete(@RequestParam(value = "ticketNum")int ticketNum) {
		ticketDeleteService.deleteTicket(ticketNum);
		return "redirect:/dvlback/ticketList";
	}
}

