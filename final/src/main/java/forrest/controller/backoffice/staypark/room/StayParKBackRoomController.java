package forrest.controller.backoffice.staypark.room;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.command.backoffice.staypark.RoomCommand;
import forrest.command.backoffice.staypark.RoptionsCommand;
import forrest.service.backoffice.staypark.room.OptionListService;
import forrest.service.backoffice.staypark.room.RoomInsertService;
import forrest.service.backoffice.staypark.room.RoomListService;
import forrest.service.backoffice.staypark.room.RoptionInsertService;

@Controller
@RequestMapping("stpback")
public class StayParKBackRoomController {
	
	@Autowired
	OptionListService optionListService;
	@Autowired
	RoomInsertService roomInsertService;
	@Autowired
	RoomListService roomListService;
	
	@RequestMapping(value = "roomList", method = RequestMethod.GET)
	public String roomList(Model model) {
		roomListService.selectRoom(model);
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoom";
	}
	
	@RequestMapping(value = "roomRegist", method = RequestMethod.GET)
	public String roomRegist() {
		
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoomRegi";
	}
	
	@RequestMapping(value = "roomRegistPro", method = RequestMethod.POST)
	public String roomRegistPro(RoomCommand command,HttpServletRequest request) {
		String location = roomInsertService.insertRoom(command, request);	
		return location;
	}
}
