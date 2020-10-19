package forrest.command.han;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalcCommand {
	Integer calcNum;
	Integer ptNum;
	Integer workNum;
	String calcDate;
	String calcTerm;
	Integer calcPrice;
	String calcContent;
}
