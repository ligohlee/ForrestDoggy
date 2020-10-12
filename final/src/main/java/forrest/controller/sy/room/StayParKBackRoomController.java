package forrest.controller.sy.room;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.sy.room.RoomCommand;
import forrest.command.sy.room.RoptionsCommand;
import forrest.service.sy.room.OptionListService;
import forrest.service.sy.room.RoomDetailService;
import forrest.service.sy.room.RoomInsertService;
import forrest.service.sy.room.RoomListService;
import forrest.service.sy.room.RoomOptionInsertService;
import forrest.service.sy.room.RoomOptionListService;




@Controller
@RequestMapping("stpback")
public class StayParKBackRoomController {
	
	@Autowired
	OptionListService optionListService;
	@Autowired
	RoomInsertService roomInsertService;
	@Autowired
	RoomListService roomListService;
	@Autowired
	RoomDetailService roomDetailService;
	@Autowired
	RoomOptionInsertService roomOptionInsertService;
	@Autowired
	RoomOptionListService roomOptionListService;
	
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
	
	@RequestMapping(value = "roomDetail", method = RequestMethod.GET)
	public String roomDetail(@RequestParam(value="roomNum") int roomNum, Model model) {
		roomDetailService.selectRoom(roomNum, model);
		optionListService.listOpt(model);
		roomOptionListService.listRopt(model,roomNum);
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backRoomDetail";
	}
	
	@RequestMapping(value = "roomOptInsert", method = RequestMethod.POST)
	public String roomOptInsert(@RequestParam(value="roomNum")String roomNum,RoptionsCommand command) {
		roomOptionInsertService.insertRoomOpt(command);	
		return "redirect:/stpback/roomDetail?roomNum="+roomNum;
	}
	
	
}
