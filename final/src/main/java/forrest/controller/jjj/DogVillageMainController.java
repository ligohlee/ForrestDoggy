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
import forrest.command.sy.PaymentCommand;
import forrest.command.sy.PointCommand;
import forrest.service.jjj.ticket.TicketCompleteService;
import forrest.service.jjj.ticket.TicketListService;
import forrest.service.jjj.ticket.TicketOrderInsertService;
import forrest.service.jjj.ticket.TicketOrderService;
import forrest.service.jjj.ticket.TicketPayService;
import forrest.service.jjj.ticket.TicketQtyService;
import forrest.service.sy.PaymentService;
import forrest.service.sy.PointService;

@Controller
@RequestMapping("dogVillage")
public class DogVillageMainController {

	@Autowired
	TicketListService ticketListService;
	@Autowired
	TicketOrderService ticketOrderService;	
	@Autowired
	PaymentService paymentService;	
	@Autowired
	PointService pointService;
	@Autowired
	TicketOrderInsertService ticketOrderInsertService;
	@Autowired
	TicketPayService ticketPayService;
	@Autowired
	TicketCompleteService ticketCompleteService;
	@Autowired
	TicketQtyService ticketQtyService;
	
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
	public String ticketOrderPro(TicketOrderCommand command, Model model, PaymentCommand paymentCommand,
			PointCommand pointCommand) {
		paymentService.insertPayment(paymentCommand);
		pointService.insertPoint(pointCommand);
		ticketOrderInsertService.insertOrder(command);
		ticketPayService.insertTicketPay(command, paymentCommand);
		ticketCompleteService.selectTorder(command,model);
		ticketQtyService.updateQty(command);
		return "thymeleaf/frontPage/html/jjj/dvlPaymentOk";
	}
}
