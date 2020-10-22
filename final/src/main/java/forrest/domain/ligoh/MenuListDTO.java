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
	Integer courseNum;
	String courseName;
	Integer menuNum;
	String menuName;
	Integer mordQty; 
	Timestamp mordTime;
	Integer coursePrice;
	Integer eachTotal;
}
