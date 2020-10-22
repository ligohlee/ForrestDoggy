package forrest.service.han.budget;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.BudgetDTO;
import forrest.domain.han.GoogleDTO;
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
	public void googleview(Integer deptNum, Model model,HttpServletResponse response)throws Exception{
		List<GoogleDTO> google = budgetMapper.googleview(deptNum);
		String googleList = "[['년도','인건비','시설관리예산','기본운영예산','비품운영예산','기타계획예산'] ";
		for (int i = 0; i < google.size(); i++) {
			googleList += ",['"+google.get(i).getBudYear()+"',"+google.get(i).getBudSalary()+","+google.get(i).getBudFacility()+","+google.get(i).getBudBasic()+","+google.get(i).getBudSup()+","+google.get(i).getBudEtc()+ "]";
		}
		googleList +="]";
		System.out.println(googleList);
		model.addAttribute("googleList", googleList);
	}
	
}
