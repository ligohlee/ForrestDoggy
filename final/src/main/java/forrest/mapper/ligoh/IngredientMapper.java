package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.IngredientDTO;

public interface IngredientMapper {

	public void ingredientInsert(IngredientDTO dto) throws Exception;

	public List<IngredientDTO> getIngreList(StartEndPageDTO dto);

	public int getIngreCount();

	public List<IngredientDTO> nameSearch(StartEndPageDTO dto);


	
}
