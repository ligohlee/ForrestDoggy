package forrest.service.sy.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.sy.room.RoptionsCommand;
import forrest.domain.sy.room.RoptionsDTO;

import forrest.mapper.sy.room.RoptionsMapper;

@Service
@Component
public class RoomOptionInsertService {
	@Autowired
	RoptionsMapper mapper;
	public void insertRoomOpt(RoptionsCommand command) {
		// TODO Auto-generated method stub
		RoptionsDTO dto = new RoptionsDTO();
		
		dto.setOptNum(command.getOptNum());
		dto.setRoomNum(command.getRoomNum());
		dto.setRoptionQty(command.getRoptionQty());
		
		mapper.insertRoptions(dto);
		
		
		
	}

}
