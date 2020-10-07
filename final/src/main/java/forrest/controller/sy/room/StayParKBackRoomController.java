package forrest.controller.sy.room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("stpback")
public class StayParKBackRoomController {
	@RequestMapping(value = "roomList", method = RequestMethod.GET)
	public String roomList() {
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoom";
	}
	
	@RequestMapping(value = "roomRegist", method = RequestMethod.GET)
	public String roomRegist() {
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoomRegi";
	}
}
