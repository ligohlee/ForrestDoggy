package forrest.service.sy.room;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.sy.PaymentCommand;
import forrest.command.sy.room.RoomOrderCommand;
import forrest.domain.sy.room.RoomOrderPayDTO;
import forrest.mapper.sy.room.RoomOrderPayMapper;


@Service
@Component
public class RoomOrderPayService {
	
	@Autowired
	RoomOrderPayMapper mapper;
	
	public void insertRoomOrderPay(PaymentCommand paymentCommand, RoomOrderCommand roderCommand) {
		// TODO Auto-generated method stub
		
		RoomOrderPayDTO dto = new RoomOrderPayDTO();
		SimpleDateFormat formmatter = new SimpleDateFormat("yyyy-MM-dd");
		Date checkIn;
		Date checkOut;
		
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
		
		dto.setPayPrice(paymentCommand.getPayPrice());
		dto.setRoomNum(roderCommand.getRoomNum());
		
		mapper.insertRoomOrderPay(dto);
		
	}

}
