package forrest.service.ligoh.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.ligoh.IngredientCommand;
import forrest.domain.ligoh.IngredientDTO;
import forrest.mapper.ligoh.IngredientMapper;

@Service
@Component
public class IngrWriteService {
	
	@Autowired
	IngredientMapper ingredientMapper;

	public String write(IngredientCommand ic) throws Exception {

		IngredientDTO dto = new IngredientDTO();
		
		  dto.setCtNum(ic.getCtNum());
		  dto.setIngrCategory(ic.getIngrCategory());
		  dto.setIngrIntro(ic.getIngrIntro());
		  dto.setIngrLimit(ic.getIngrLimit());
		  dto.setIngrMade(ic.getIngrMade());
		  dto.setIngrName(ic.getIngrName());
		  dto.setIngrQty(ic.getIngrQty());
		  dto.setIngrStorage(ic.getIngrStorage());
		  dto.setPtNum(ic.getPtNum());
		  
			
		  ingredientMapper.ingredientInsert(dto);
		 String	location = "redirect:/espback/ingredient/ingrList";
		
			
			return location;
		}

}
