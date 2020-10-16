package forrest.command.han;







import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetCommand {
	Integer deptNum;
	Integer budNum;
	String budYear;
	Integer budSalary;
	Integer budFacility;
	Integer budBasic;
	Integer budSup;
	Integer budEtc;
}
