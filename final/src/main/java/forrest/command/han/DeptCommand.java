package forrest.command.han;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptCommand {
	Integer deptNum;
	String deptName;
	String deptPh;
}
