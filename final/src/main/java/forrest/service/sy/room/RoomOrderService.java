package forrest.service.sy.room;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.sy.room.RoomOrderCommand;
import forrest.domain.sy.room.RorderDTO;
import forrest.mapper.sy.room.RoomOrderMapper;


@Service
@Component
public class RoomOrderService {

	@Autowired
	RoomOrderMapper roomOrderMapper;
	public void insertOrder(RoomOrderCommand roderCommand) {
		// TODO Auto-generated method stub
		
		RorderDTO dto = new RorderDTO();
		
		SimpleDateFormat formmatter = new SimpleDateFormat("yyyy-MM-dd");
		Date checkIn;
		Date checkOut;
		//System.out.println(roderCommand.getCheckIn());
		//System.out.println(roderCommand.getCheckOut());
		
		try {
			checkIn = formmatter.parse(roderCommand.getCheckIn());
			checkOut = formmatter.parse(roderCommand.getCheckOut());
			Timestamp checkInTime = new Timestamp(checkIn.getTime());
			Timestamp checkOutTime = new Timestamp(checkOut.getTime());
			dto.setCheckIn(checkInTime);
			dto.setCheckOut(checkOutTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		dto.setMemId(roderCommand.getMemId());
		dto.setRoName(roderCommand.getRoName());
		dto.setRoomNum(roderCommand.getRoomNum());
		dto.setRoPh(roderCommand.getRoPh());
		dto.setRoReq(roderCommand.getRoReq());
		System.out.println(dto);
		roomOrderMapper.insertRoomOrder(dto);
		
		
	}
	

}
