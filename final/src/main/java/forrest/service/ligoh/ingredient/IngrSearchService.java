package forrest.service.ligoh.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.EvaluationDTO;
import forrest.mapper.ligoh.EvaluationMapper;

@Service
@Component
public class IngrSearchService {
	@Autowired
	EvaluationMapper evaluationMapper;
	

	public void ingrSel(String ingrName, Model model) throws Exception {
		
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, ingrName, null);
		
		List<EvaluationDTO> lists = evaluationMapper.ingredientSearch(dto);
	       System.out.println(ingrName);
		model.addAttribute("lists", lists);
		
		
	}


	
}
