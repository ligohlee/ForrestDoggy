package forrest.domain.ligoh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO {
	Integer ctNum;
	
	Integer ptNum;
	Integer workNum;
	String ctTerm;
	String ctPtName;
	String ctPtPh;
	String ctContent;
	
	String ctImage;

}
