package forrest.service.han.budget;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.BudgetDTO;
import forrest.mapper.han.BudgetMapper;

@Component
@Service
public class BudgetlistService {
	@Autowired 
	BudgetMapper budgetMapper;
	public void listView(Model model)throws Exception{
		List<BudgetDTO> lists = budgetMapper.budlistview();
		model.addAttribute("lists", lists);
	}
}
