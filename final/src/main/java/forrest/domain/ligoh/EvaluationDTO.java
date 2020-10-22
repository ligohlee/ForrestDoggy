package forrest.domain.ligoh;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDTO {
	Integer evalNum;
	Integer ptNum;
	String ptName;
	
	Timestamp evalDate;
	String evalIngr;
	Double evalPrice;
	String evalDesc;
	String evalResult;
	String ingrImg;
	String ctContent;
	Integer ctNum;
	

}
