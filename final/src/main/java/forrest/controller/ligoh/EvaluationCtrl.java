package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.ligoh.EvaluationCommand;
import forrest.service.ligoh.contract.PtSearchService;
import forrest.service.ligoh.evaluation.EvalDetailService;
import forrest.service.ligoh.evaluation.EvalListService;
import forrest.service.ligoh.evaluation.EvalWriteService;

@Controller
@RequestMapping("espback/evaluation")
public class EvaluationCtrl {
	
	@Autowired
	PtSearchService ptSearchService;
	@Autowired
	EvalWriteService evalWriteService;
	@Autowired
	EvalListService evalListService;
	@Autowired
	EvalDetailService evalDetailService;

	
	
	@RequestMapping(value = "eval")
	public String evaluationList(@RequestParam(value="page", defaultValue="1")Integer page, Model model) throws Exception {
		       evalListService.evalList(model, page);
		return "thymeleaf/backOfficePage/html/esp_manager/evaluation/ev_list";
	}
	@RequestMapping(value = "evRegist", method = RequestMethod.GET)
	public String evRegist() {
		return "thymeleaf/backOfficePage/html/esp_manager/evaluation/ev_regist";
	}
	@RequestMapping(value = "partnerCheck", method = RequestMethod.GET)
	public String ptChk() {
		return "thymeleaf/backOfficePage/html/pt_manager/partnerCheck";
	}
	@RequestMapping(value = "ptSearch", method = RequestMethod.POST)
	public String ptSearch(@RequestParam(value="ptName") String ptName, Model model) throws Exception {
		ptSearchService.ptSel(ptName, model);
		return "thymeleaf/backOfficePage/html/pt_manager/partnerCheck2";
	}
	@RequestMapping(value = "evalInsert",method = RequestMethod.POST)
    public String contractWrite(@Validated EvaluationCommand evaluationCommand, 
   		 BindingResult result) throws Exception{
		 if (result.hasErrors()) {
			System.out.println("writePro");
			 return "thymeleaf/backOfficePage/html/esp_manager/evaluation/ev_regist";
		}
		 String location = evalWriteService.write(evaluationCommand);
			return location;
	}

	@RequestMapping(value = "evalDetail", method = RequestMethod.GET)
	public String contractDetail(@RequestParam(value="evalNum") String evalNum, Model model) throws Exception{
		evalDetailService.evDetail(evalNum, model);
		return "thymeleaf/backOfficePage/html/esp_manager/evaluation/ev_detail";
	}

}

