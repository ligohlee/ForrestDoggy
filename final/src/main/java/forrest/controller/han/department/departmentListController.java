package forrest.controller.han.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("worker")
public class departmentListController {
	@RequestMapping("departmentList")
	public String list() {
		return "thymeleaf/backOfficePage/html/department_manager/deptlist";
	}
	@RequestMapping("deptWrite")
	public String write() {
		return "thymeleaf/backOfficePage/html/department_manager/dept_write";
	}
	
}
