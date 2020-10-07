package forrest.command.han;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerCommand {
	Integer workNum;
	Integer deptNum;
	String workPass;
	String workName;
	String workPh;
	String workEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date hireDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date workBorn;
	String position;
	String job;
	Integer workHoli;
	String workAddr;
	MultipartFile workImg;
	
}
