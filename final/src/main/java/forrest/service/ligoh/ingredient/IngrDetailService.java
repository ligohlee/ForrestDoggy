package forrest.service.ligoh.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.IngredientDTO;
import forrest.mapper.ligoh.IngredientMapper;

@Service
@Component
public class IngrDetailService {
	@Autowired
	IngredientMapper ingredientMapper;

	public void ingrDetail(String ingrNum, Model model) {
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1l, 1l, null, ingrNum);
		IngredientDTO dto = ingredientMapper.getIngreList(startEndPageDTO).get(0);
		
		model.addAttribute("detail", dto);
			
		}
		
	}


