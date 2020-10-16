package forrest.domain.han;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetDTO {
	Integer deptNum;
	Integer budNum;
	Timestamp budYear;
	Integer budSalary;
	Integer budFacility;
	Integer budBasic;
	Integer budSup;
	Integer budEtc;
}
