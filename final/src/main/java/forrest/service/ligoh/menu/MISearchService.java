package forrest.service.ligoh.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.IngredientDTO;
import forrest.mapper.ligoh.IngredientMapper;

@Service
@Component
public class MISearchService {
	@Autowired
	IngredientMapper ingredientMapper;

	public void ingrSearch(String ingrName, Model model, String menuNum) {
		
        StartEndPageDTO dto = new StartEndPageDTO(1L, 10L, ingrName, null);
		
		List<IngredientDTO> lists = ingredientMapper.getIngreList(dto);
	       System.out.println(ingrName);
	    model.addAttribute("menuNum", menuNum);
		model.addAttribute("lists", lists);
		
		
	}

	public void ingrSearch2(String ingrNum, Model model, String menuNum) {
       StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, ingrNum);
		
		List<IngredientDTO> lists = ingredientMapper.getIngreList(dto);
	    model.addAttribute("menuNum", menuNum);
		model.addAttribute("lists", lists);
		
	}

}
