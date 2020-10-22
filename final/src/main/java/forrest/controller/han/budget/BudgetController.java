package forrest.controller.han.budget;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.han.BudgetCommand;
import forrest.service.han.budget.BudgetDetailService;
import forrest.service.han.budget.BudgetService;
import forrest.service.han.budget.BudgetlistService;

@Controller
@RequestMapping("departmentMain")
public class BudgetController {
	@Autowired
	BudgetService budgetService;
	@Autowired
	BudgetlistService budgetlistService;
	@Autowired
	BudgetDetailService budgetDetailService;
	@RequestMapping("budget")
	public String budgetlist(Model model)throws Exception {
		budgetlistService.listView(model);
		return "thymeleaf/backOfficePage/html/budget_manager/budget_List";
	}
	@RequestMapping("budgetWrite")
	public String write() {
		System.out.println("bbbb");
		return "thymeleaf/backOfficePage/html/budget_manager/budget_write";
	}
	@RequestMapping("budgetwritePro")
	public String writePro(BudgetCommand budgetCommand)throws Exception {
		System.out.println(budgetCommand);
		budgetService.budInsert(budgetCommand);
		return "redirect:budget";
	}
	@RequestMapping("googleChartPage")
	public String chartmain(@RequestParam(value = "deptNum")Integer deptNum,Model model)throws Exception{
		budgetDetailService.Detaillist(deptNum,model);
		return "thymeleaf/backOfficePage/html/budget_manager/chartlist";
	}
	@RequestMapping("budgetDetail")
	public String Detail(@RequestParam(value = "budNum")Integer budNum,Model model) throws Exception{
		budgetDetailService.Detailbudget(budNum,model);
		return "thymeleaf/backOfficePage/html/budget_manager/budget_view";
	}

	@RequestMapping("goolechart")
	public String chartlist(@RequestParam(value = "deptNum")Integer deptNum,Model model, HttpServletResponse response)throws Exception{
		budgetlistService.googleview(deptNum, model, response);
		return "thymeleaf/backOfficePage/html/budget_manager/budget_chart";  

	}
	

}
