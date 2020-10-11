package forrest.domain.ligoh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
	Integer IngrNum;
	Integer ptNum;
	Integer ctNum;
    String	ingrName;
    String	ingrCategory;
    String	ingrMade;
    String	ingrStorage;
    Integer ingrQty;
    String	ingrIntro;
    Integer ingrLimit;
    String ptName;
	

}
