package forrest.command.ligoh;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractCommand {

	Integer ptNum;
	Integer workNum;
	
	String ctTerm;
	
	String ctPtName;
	String ctPtPh;
	String ctContent;
	
	MultipartFile [] report;

}
