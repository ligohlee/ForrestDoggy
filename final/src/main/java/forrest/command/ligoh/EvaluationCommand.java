package forrest.command.ligoh;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationCommand {
	Integer evalNum;
	Integer ptNum;
	String evalIngr;
	Double evalPrice;
	String evalDesc;
	String evalResult;
	MultipartFile [] report;


	
}
