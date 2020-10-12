package forrest.command.sy.room;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RoomSerchCommand {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date checkIn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date checkOut;
	
	Integer capacity;
	
}
