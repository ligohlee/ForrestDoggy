package forrest.domain.han;




import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {
	Integer workNum;
	Integer deptNum;
	String workPass;
	String workName;
	String workPh;
	String workEmail;
	Timestamp hireDate;
	Timestamp workBorn;
	String position;
	String job;
	Integer workHoli;
	String workAddr;
	String workImg;
	
}
