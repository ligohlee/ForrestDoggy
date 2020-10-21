package forrest.service.sy.room;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.sy.room.OptionsDTO;
import forrest.domain.sy.room.RoomDTO;
import forrest.domain.sy.room.RorderDTO;
import forrest.mapper.sy.room.RoomMapper;




@Service
@Component
public class RoomListService {
	
	@Autowired
	RoomMapper roomMapper;
	public void selectRoom(String checkIn, String checkOut, String capacity, Model model) {
		// TODO Auto-generated method stub
		
		RoomDTO dto = new RoomDTO();
		dto.setCapacity(Integer.parseInt(capacity));
		
		SimpleDateFormat formmatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date checkIn1 = formmatter.parse(checkIn);
			Date checkOut1 = formmatter.parse(checkOut);
			Timestamp checkIn2 = new Timestamp(checkIn1.getTime());
			Timestamp checkOut2 = new Timestamp(checkOut1.getTime());
			dto.setCheckIn(checkIn2);
			dto.setCheckOut(checkOut2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(dto);
		
		List<RoomDTO> list = roomMapper.selectRoom(dto);
		model.addAttribute("roomList", list);
		System.out.println(list);
		
	}

}
