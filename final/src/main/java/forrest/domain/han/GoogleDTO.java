package forrest.domain.han;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleDTO {
	Integer deptNum;
	String budYear;
	String budSalary;
	String budFacility;
	String budBasic;
	String budSup;
	String budEtc;
}
