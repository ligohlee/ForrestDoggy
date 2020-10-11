package forrest.service.sy.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.sy.room.RoomDTO;
import forrest.mapper.sy.room.RoomMapper;

@Service
@Component
public class RoomDetailService {
	@Autowired
	RoomMapper mapper;
	public void selectRoom(int roomNum, Model model) {
		// TODO Auto-generated method stub
		RoomDTO roomNum1 = new RoomDTO();
		roomNum1.setRoomNum(roomNum);
		RoomDTO dto = mapper.selectRoom(roomNum1).get(0);
		model.addAttribute("room", dto);
		
		
	}
	

}
