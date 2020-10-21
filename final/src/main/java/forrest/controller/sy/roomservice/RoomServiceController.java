package forrest.controller.sy.roomservice;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import forrest.service.sy.roomservice.RoomServiceOrderService;


@Controller
@RequestMapping("staypark")
public class RoomServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoomServiceController.class);
	
	@Autowired
	RoomServiceOrderService roomServiceOrderService;
	
	@RequestMapping(value = "roomService", method = RequestMethod.GET)
	public String roomService(HttpSession session, Model model) {
		String path = roomServiceOrderService.orderRoomService(session, model);		
		return path;
	}
}
