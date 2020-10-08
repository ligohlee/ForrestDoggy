package forrest.domain.han;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {
	Integer deptNum;
	String deptName;
	String deptPh;
}
