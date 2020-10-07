package forrest.controller.han.worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.han.WorkerCommand;
import forrest.service.han.worker.WorkerDeleteService;
import forrest.service.han.worker.WorkerDetailService;
import forrest.service.han.worker.WorkerService;
import forrest.service.han.worker.WorkerlistService;
import forrest.service.han.worker.WorkermodifyProService;
@Controller
@RequestMapping("worker")
public class WorkerController {
	@Autowired
	WorkerService workerService;
	@Autowired
	WorkerlistService workerlistService;
	@Autowired
	WorkerDetailService workerDetailService;
	@Autowired
	WorkermodifyProService workermodifyProService;
	@Autowired
	WorkerDeleteService workerDeleteService;
	@RequestMapping("main")
	public String list() {
		return "thymeleaf/backOfficePage/html/worker_manager/worker_backMain";
	}
	@RequestMapping("workContract")
	public String conteact(Model model)throws Exception {
		workerlistService.worklist(model);
		return "thymeleaf/backOfficePage/html/worker_manager/worker_contract";
	}
	@RequestMapping("WorkerRegist")
	public String regist() {
		return "thymeleaf/backOfficePage/html/worker_manager/worker_regist";
	}
	@RequestMapping("workerForm")
	public String writePro(WorkerCommand workerCommand, HttpServletRequest request)throws Exception {
	String location	= workerService.workInsert(workerCommand, request);
		return location;
	}
	@RequestMapping("WorkerDetail")
	public String WorkerDetail(@RequestParam(value = "workNum")Integer workNum,Model model)throws Exception {
		workerDetailService.detailview(workNum,model);
		return "thymeleaf/backOfficePage/html/worker_manager/work_view";
	}
	@RequestMapping("workerModifyPro")
	public String workermodify(@RequestParam(value = "workNum")Integer workNum,Model model)throws Exception {
		System.out.println(workNum+"aaaa");
		workerDetailService.detailview(workNum,model);
		return "thymeleaf/backOfficePage/html/worker_manager/worker_modify";
	}
	@RequestMapping("workerModify")
	public String modifyPro(WorkerCommand command,HttpSession session)throws Exception{
		String location = workermodifyProService.insertmodify(command,session);
		return location;
	}
	@RequestMapping("workerDel")
	public String workDel(@RequestParam(value = "workNum")Integer workNum, Model model)throws Exception {
		model.addAttribute("workNum", workNum);
		return "thymeleaf/backOfficePage/html/worker_manager/worker_delet";
	}
	@RequestMapping("workerDelPro")
	public String workDelPro(@RequestParam(value = "workNum")Integer workNum)throws Exception{
		workerDeleteService.delpro(workNum);
		return "redirect:/worker/workContract";
	}

}
