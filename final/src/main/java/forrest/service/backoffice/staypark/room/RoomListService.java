package forrest.service.backoffice.staypark.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.backoffice.staypark.OptionsDTO;
import forrest.mapper.backoffice.staypark.room.RoomMapper;

@Service
@Component
public class RoomListService {
	
	@Autowired
	RoomMapper roomMapper;
	public void selectRoom(Model model) {
		// TODO Auto-generated method stub
		List<OptionsDTO> list = roomMapper.selectRoom();
		model.addAttribute("roomList", list);
		
	}

}
