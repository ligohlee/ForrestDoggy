package forrest.command.ligoh;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractCommand {
	String ptName;
	@NotEmpty(message="제목을 적어주세요")
	String ctTerm;
	String workName;
	String ctPtName;
	String ctPtPh;
	String ctContent;
	MultipartFile [] report;

}
