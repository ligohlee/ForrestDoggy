package forrest.controller.sy.myrsv;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.service.sy.room.RoomOrderService;

@Controller
@RequestMapping("staypark")
public class StayParkMyRsvController {
	
	@Autowired
	RoomOrderService roomOrderService;
	
	@RequestMapping(value = "myReservation", method = RequestMethod.GET)
	public String myReservation(Model model, HttpSession session) {
		roomOrderService.selectMyRsv(model, session);
		return "thymeleaf/frontPage/html/sy/stpMyReservation";
	}
	
	
}
