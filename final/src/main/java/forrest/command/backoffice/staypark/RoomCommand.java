package forrest.command.backoffice.staypark;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RoomCommand {
	

	   int roomNum;
	   
	   String roomName;

	   String roomInfo;

	   int roomPrice;

	   String roomImg;

	   int capacity;
	   
	   int dogCap;
	   

	
	
}