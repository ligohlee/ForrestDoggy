package forrest.service.sy.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.sy.room.OptionsDTO;
import forrest.domain.sy.room.RoomDTO;
import forrest.mapper.sy.room.RoomMapper;




@Service
@Component
public class RoomListService {
	
	@Autowired
	RoomMapper roomMapper;
	public void selectRoom(Model model) {
		// TODO Auto-generated method stub
		List<RoomDTO> list = roomMapper.selectRoom(null);
		model.addAttribute("roomList", list);
		
	}

}
