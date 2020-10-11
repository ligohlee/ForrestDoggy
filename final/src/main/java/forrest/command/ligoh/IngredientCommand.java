package forrest.command.ligoh;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCommand {
	Integer ptNum;
	Integer ctNum;
	@NotEmpty(message="필수 입력")
    String	ingrName;
    String	ingrCategory;
    String	ingrMade;
    String	ingrStorage;
    Integer ingrQty;
    String	ingrIntro;
    Integer ingrLimit;
	

}
