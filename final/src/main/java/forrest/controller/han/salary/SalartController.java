package forrest.controller.han.salary;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.han.SalCommand;
import forrest.service.han.salary.SalListServie;
import forrest.service.han.salary.SalServie;
import forrest.service.han.salary.SaldetailServie;

@Controller
@RequestMapping("worker")
public class SalartController {
	@Autowired
	SalServie salServie;
	@Autowired
	SalListServie salListServie;
	@Autowired
	SaldetailServie saldetailServie;
	@RequestMapping("salaryList")
	public String list(Model model)throws Exception {
		salListServie.Listview(model);
		return "thymeleaf/backOfficePage/html/salary_manager/salary_List";
	}
	@RequestMapping("salWrite")
	public String write() {
		return "thymeleaf/backOfficePage/html/salary_manager/salary_write";
	}
	@RequestMapping("salwritePro")
	public String writePro(SalCommand salCommand, HttpServletRequest request)throws Exception {
		String location = salServie.salInsert(salCommand,request);
		return location;
	}
	@RequestMapping("SalaryDetail")
	public String detail(@RequestParam(value = "workNum")Integer workNum,Model model)throws Exception{
		saldetailServie.salDetail(workNum,model);
		return "thymeleaf/backOfficePage/html/salary_manager/salary_view";
	}
}
