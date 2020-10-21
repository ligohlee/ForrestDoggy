package forrest.domain.ligoh;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuListDTO {
	Integer mordNum;
	Integer menuNum;
	Integer mordQty; 
	Timestamp mordTime;
}
