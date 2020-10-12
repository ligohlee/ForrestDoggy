package forrest.service.ligoh.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.controller.page.PageAction;
import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.IngredientDTO;
import forrest.mapper.ligoh.IngredientMapper;


@Service
@Component
public class IngrListService {
	
	@Autowired
	IngredientMapper ingredientMapper;

	public void ingrList(Model model, Integer page) {
		
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);	
		
		
	    List<IngredientDTO> lists = ingredientMapper.getIngreList(dto);
	
	
	    int count = ingredientMapper.getIngreCount();
	
	    model.addAttribute("count", count);
	    model.addAttribute("lists", lists);
	    PageAction pageAction = new PageAction();
	    pageAction.page(model, count, limit, limitPage, page, "ingrList");
	
		
	}

}
