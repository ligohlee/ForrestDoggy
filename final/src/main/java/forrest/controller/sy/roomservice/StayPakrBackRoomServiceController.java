
package forrest.controller.sy.roomservice;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import forrest.command.LoginCommand;
import forrest.command.sy.room.ChatNameCommand;
import forrest.service.jjj.member.MemberSelectService2;

import forrest.command.sy.room.ChatNameCommand;


import forrest.service.sy.roomservice.RoomServiceOrderService;

@Controller
@RequestMapping("stpback")
public class StayPakrBackRoomServiceController {
	
	@Autowired
	RoomServiceOrderService rsoService;
	@Autowired
	MemberSelectService2 memberSelectService2;


	@Autowired
	RoomServiceOrderService roomServiceOrderService;
	
	
	@RequestMapping(value = "roomServiceChat", method = RequestMethod.GET)
	public String roomService() {
		
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoomService";
	}
	
	@RequestMapping(value = "chatRegi", method = RequestMethod.POST)
	public String chatRegi(@RequestParam(value="memId")String memId, @RequestParam(value="memPass")String memPass,
			Model model, HttpSession session, ChatNameCommand command) {

		memberSelectService2.selectMember(memId , memPass ,session);

		String path = roomServiceOrderService.orderRoomService(session, model, command);		
		return path;
		
	}
	
}

