package forrest.service.sy.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.sy.room.OptionsDTO;

import forrest.mapper.sy.room.RoptionsMapper;

@Service
@Component
public class RoomOptionListService {
	
	@Autowired
	RoptionsMapper mapper;
	public void listRopt(Model model, Integer roomNum) {
		// TODO Auto-generated method stub
		List<OptionsDTO> list = mapper.selectRoptions(roomNum);
		model.addAttribute("roptList", list);
	}

}
