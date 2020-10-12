package forrest.domain.han;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalDTO {
	Integer salNum;
	Integer workNum;
	Integer salNow;
	Integer salIncre;
	Timestamp salYear;
	String salCont;
	String salImage;
}
