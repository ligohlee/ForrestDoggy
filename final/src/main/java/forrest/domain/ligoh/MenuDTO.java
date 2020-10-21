package forrest.domain.ligoh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
	 Integer menuNum;
	 String menuName;
	 Double menuPrice;
	 String recipe;
	 String menuIntro;
	 String allergy; 
	 String menuType;
	 Integer menuSeq;
	 String menuImage;

}
