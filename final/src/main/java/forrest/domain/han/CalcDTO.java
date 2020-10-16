package forrest.domain.han;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalcDTO {
	Integer calcNum;
	Integer ptNum;
	Integer workNum;
	Timestamp calcDate;
	String calcTerm;
	Integer calcPrice;
	String calcContent;
}
