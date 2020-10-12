package forrest.controller.ligoh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.FileDownload;
import forrest.command.ligoh.ContractCommand;
import forrest.service.ligoh.contract.CtDetailService;
import forrest.service.ligoh.contract.CtListService;
import forrest.service.ligoh.contract.CtWriteService;
import forrest.service.ligoh.contract.PtSearchService;
import forrest.service.ligoh.contract.WorkSearchService;


@Controller
@RequestMapping("ptback")
public class FoodPtController {
	
	
	
	@ModelAttribute
	ContractCommand setContractCommand(){
		return new ContractCommand();
	}
	
	@Autowired
	CtWriteService ctWriteService;
	@Autowired
	CtListService ctListService;
	@Autowired
	PtSearchService ptSearchService;
	@Autowired
	WorkSearchService workSearchService;
	@Autowired
	CtDetailService ctDetailService;
	@Autowired
	FileDownload fileDownload;
	
	
	@RequestMapping(value = "foodContract")
	public String foodCT(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		        ctListService.ctList(model,page);
		return "thymeleaf/backOfficePage/html/pt_manager/ct_list";
	}
	@RequestMapping(value = "ctRegist", method = RequestMethod.GET)
	public String foodPtCont() {
		return "thymeleaf/backOfficePage/html/pt_manager/ct_regist";
	}
	@RequestMapping(value = "contractInsert",method = RequestMethod.POST)
    public String contractWrite(@Validated ContractCommand contractCommand, 
   		 BindingResult result, HttpServletRequest request) throws Exception{
		 if (result.hasErrors()) {
			System.out.println("writePro");
			 return "thymeleaf/backOfficePage/html/pt_manager/ct_regist";
		}
		 String location = ctWriteService.write(contractCommand,request);
			return location;
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
	@RequestMapping(value = "workCheck", method = RequestMethod.GET)
	public String workCheck() {
		return "thymeleaf/backOfficePage/html/pt_manager/workCheck";
	}
	@RequestMapping(value = "workSearch", method = RequestMethod.POST)
	public String workSearch(@RequestParam(value="workName") String workName, Model model) throws Exception {
		workSearchService.wkSel(workName, model);
		
		return "thymeleaf/backOfficePage/html/pt_manager/workCheck2";
	}
	
	@RequestMapping(value = "contractDetail", method = RequestMethod.GET)
	public String contractDetail(@RequestParam(value="ctNum") String ctNum, Model model) throws Exception{
		ctDetailService.ctDetail(ctNum, model);
		return "thymeleaf/backOfficePage/html/pt_manager/ct_detail";
	}
	@RequestMapping(value = "fileDown",method = RequestMethod.GET)
	public void fileDown(@RequestParam(value="file") String fileName,
			HttpServletResponse response, HttpServletRequest request) throws Exception{
		   String path = "/static/upload/contract";
		fileDownload.fileDownLoad(path, fileName, request,response);
	}
	

}
