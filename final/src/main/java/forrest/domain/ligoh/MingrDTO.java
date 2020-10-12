package forrest.domain.ligoh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MingrDTO {
	Integer menuNum;
	Integer ingrNum;
	Integer menuIngrQty;
	String ingrName;
}
