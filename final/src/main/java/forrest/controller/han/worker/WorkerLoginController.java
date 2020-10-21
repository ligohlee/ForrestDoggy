package forrest.controller.han.worker;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.han.workerlogin.WorkerSelectService;

@Controller
@RequestMapping("backoffice")
public class WorkerLoginController {
	@Autowired
	WorkerSelectService workerSelectService;
	@RequestMapping("login")
	public String main() {
		return "thymeleaf/backOfficePage/html/worker_login";
	}
	@RequestMapping("workerloginPro")
	public String loginPro(@RequestParam(value = "workNum")Integer workNum,@RequestParam(value = "workPass")String workPass, HttpSession session) {
		return workerSelectService.selectWorker(workNum,workPass,session);
		
	}
	@RequestMapping(value = "workerlogout")
	public String logout() {
		
		return  "thymeleaf/backOfficePage/html/worker_login";
	}
}
