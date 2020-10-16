package forrest.command.jjj;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilityCommand {
	

	String facName;
	String facInfo;
	MultipartFile facImg;
}



