package forrest.controller.sy.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.sy.room.RoomDetailService;
import forrest.service.sy.room.RoomListService;
import forrest.service.sy.room.RoomOptionListService;

@Controller
@RequestMapping("staypark")
public class StayParkRoomController {
	
	@Autowired
	RoomListService roomListService;
	@Autowired
	RoomDetailService roomDetailService;
	@Autowired
	RoomOptionListService roomOptionListService;
	
	@RequestMapping(value = "roomReservation", method = RequestMethod.GET)
	public String roomReservation() {
		return "thymeleaf/frontPage/html/stpRoomReservation";
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
		return "thymeleaf/frontPage/html/stpRoomList";
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
		return "thymeleaf/frontPage/html/stpRoomDetail";
	}

}
