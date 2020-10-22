package forrest.controller.sy.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.sy.room.RoomOrderService;
import forrest.service.sy.room.SelOptionService;

@Controller
@RequestMapping("stpback")
public class StayParkBackRoomOrderController {
	
	@Autowired
	RoomOrderService roomOrderService;
	@Autowired
	SelOptionService selOptService;
	
	
	@RequestMapping(value = "roomOrderList", method = RequestMethod.GET)
	public String roomOrderList(Model model) {
		roomOrderService.selectList(model,null);
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoomOrderList";
	}
	@RequestMapping(value = "roomOrderDetail", method = RequestMethod.GET)
	public String roomOrderDetail(@RequestParam(value="roNum")int roNum, Model model) {
		roomOrderService.selectList(model,roNum);
		selOptService.selectSelOpt(model,roNum);
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoomOrderDetail2";
	}
	
	
	
	
	

}
