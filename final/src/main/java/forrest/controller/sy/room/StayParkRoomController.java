package forrest.controller.sy.room;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.sy.PaymentCommand;
import forrest.command.sy.PointCommand;
import forrest.command.sy.room.RoomOrderCommand;
import forrest.command.sy.room.RoomReservationInfoCommand;
import forrest.service.sy.PaymentService;
import forrest.service.sy.PointService;
import forrest.service.sy.room.RoomDetailService;
import forrest.service.sy.room.RoomListService;
import forrest.service.sy.room.RoomOptionListService;
import forrest.service.sy.room.RoomRsvInfoService;

@Controller
@RequestMapping("staypark")
public class StayParkRoomController {
	
	@Autowired
	RoomListService roomListService;
	@Autowired
	RoomDetailService roomDetailService;
	@Autowired
	RoomOptionListService roomOptionListService;
	@Autowired
	RoomRsvInfoService roomRsvInfoService;	
	@Autowired
	PaymentService paymentService;	
	@Autowired
	PointService pointService;
	@Autowired
	RoomOrderService roomOrderService;
	
	@RequestMapping(value = "roomReservation", method = RequestMethod.GET)
	public String roomReservation() {
		return "thymeleaf/frontPage/html/sy/stpRoomReservation";
	}
	
	@RequestMapping(value = "roomList", method = RequestMethod.POST)
	public String roomList(@RequestParam(value="checkIn") String checkIn, 
			@RequestParam(value="checkOut") String checkOut,
			@RequestParam(value="capacity") String capacity,
			Model model) {
		roomListService.selectRoom(model);
		model.addAttribute("checkIn", checkIn);
		model.addAttribute("checkOut", checkOut);
		model.addAttribute("capacitySelect", capacity);
		return "thymeleaf/frontPage/html/sy/stpRoomList";
	}
	
	@RequestMapping(value = "roomDetail", method = RequestMethod.GET)
	public String roomDetail(@RequestParam(value="checkIn") String checkIn, 
			@RequestParam(value="checkOut") String checkOut,
			@RequestParam(value="capacitySelect") String capacitySelect, @RequestParam(value="roomNum")int roomNum, Model model) {
		roomDetailService.selectRoom(roomNum, model);
		roomOptionListService.listRopt(model,roomNum);
		model.addAttribute("checkIn", checkIn);
		model.addAttribute("checkOut", checkOut);
		model.addAttribute("capacitySelect", capacitySelect);
		return "thymeleaf/frontPage/html/sy/stpRoomDetail";
	}
	
	@RequestMapping(value = "roomOrder", method = RequestMethod.POST)
	public String roomOrder(@RequestParam(value="roomNum")int roomNum,RoomReservationInfoCommand command, Model model, HttpSession session) {		

		roomDetailService.selectRoom(roomNum, model);
		roomOptionListService.listRopt(model,roomNum);
		roomRsvInfoService.infoRsv(command, model, session);
		model.addAttribute("rsvInfo", command);
		return "thymeleaf/frontPage/html/sy/stpRoomOrderList";
	}
	
	@RequestMapping(value = "roomOrderPro", method = RequestMethod.POST)
	public String roomOrderPro(PaymentCommand paymentCommand,PointCommand pointCommand, RoomOrderCommand roderCommand, Model model  ) {				
		paymentService.insertPayment(paymentCommand);
		pointService.insertPoint(pointCommand);
		roomOrderService.insertOrder(roderCommand);
		return "thymeleaf/frontPage/html/sy/stpPaymentOk";
	}
	
	

}
