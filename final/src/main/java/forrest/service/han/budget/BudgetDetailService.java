package forrest.service.han.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.BudgetDTO;
import forrest.mapper.han.BudgetMapper;

@Component
@Service
public class BudgetDetailService {
	@Autowired
	BudgetMapper budgetMapper;
	public void Detailbudget(Integer budNum, Model model)throws Exception {
		BudgetDTO dto = budgetMapper.buddetailview(budNum);
		model.addAttribute("dto", dto);
	}
}
