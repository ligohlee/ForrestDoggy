package forrest.controller.han.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.han.DeptCommand;
import forrest.service.han.dept.DeptService;
import forrest.service.han.dept.DeptdetailService;
import forrest.service.han.dept.DeptlistService;
import forrest.service.han.dept.DeptmodiProService;

@Controller
@RequestMapping("worker")
public class departmentListController {
	@Autowired
	DeptService deptService;
	@Autowired
	DeptlistService deptlistService;
	@Autowired
	DeptdetailService deptdetailService;
	@Autowired
	DeptmodiProService deptmodiProService;
	@RequestMapping("departmentList")
	public String list(Model model)throws Exception {
		deptlistService.deptlist(model);
		return "thymeleaf/backOfficePage/html/department_manager/deptlist";
	}
	@RequestMapping("deptWrite")
	public String write() {
		return "thymeleaf/backOfficePage/html/department_manager/dept_write";
	}
	@RequestMapping("deptwritePro")
	public String writePro(DeptCommand deptCommand)throws Exception {
		deptService.deptinsert(deptCommand);
		return "redirect:/worker/departmentList";
	}
	@RequestMapping("deptdetail")
	public String detail(@RequestParam(value = "deptNum")Integer deptNum,Model model)throws Exception {
		deptdetailService.deptdetail(deptNum,model);
		return "thymeleaf/backOfficePage/html/department_manager/dept_Detail";
	}
	@RequestMapping("deptModify")
	public String modify(@RequestParam(value = "deptNum")Integer deptNum,Model model)throws Exception{
		deptdetailService.deptdetail(deptNum,model);
		return "thymeleaf/backOfficePage/html/department_manager/dept_Modify";
	}
	@RequestMapping("deptModifyPro")
	public String modifyPro(DeptCommand command)throws Exception{
		deptmodiProService.deptModipro(command);
		return "redirect:/worker/deptdetail?deptNum=" +command.getDeptNum();
	}
}
