package forrest.command.jjj;





import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilityCommand {
	
	 
	String facilityName;
	String facilityInfo;
	String facilityImg;
   
	String facilityRegist;

}



