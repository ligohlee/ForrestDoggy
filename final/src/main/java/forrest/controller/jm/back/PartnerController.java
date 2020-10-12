package forrest.controller.jm.back;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jm.PartnerCommand;
import forrest.service.jm.partner.PartnerDeleteService;
import forrest.service.jm.partner.PartnerDetailService;
import forrest.service.jm.partner.PartnerListService;
import forrest.service.jm.partner.PartnerModifyService;
import forrest.service.jm.partner.PartnerWriteService;

@Controller
@RequestMapping("partner")
public class PartnerController {
	@Autowired
	PartnerListService partnerListService;
	@Autowired
	PartnerWriteService partnerWriteService;
	@Autowired
	PartnerDetailService partnerDetailService;
	@Autowired
	PartnerModifyService partnerModifyService;
	@Autowired
	PartnerDeleteService partnerDeleteService;
	
	@ModelAttribute
	PartnerCommand setPartnerCommand() {
		return new PartnerCommand();
	}
	@RequestMapping("partnerList")
	public String partnerList(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		partnerListService.partnerList(model, page);
		return "thymeleaf/backOfficePage/html/pt_manager/pt_list";
	}
	@RequestMapping("partnerWrite")
	public String partnerWrite() {
		return "thymeleaf/backOfficePage/html/pt_manager/pt_form";
	}
	@RequestMapping(value="partnerWritePro", method=RequestMethod.POST)
	public String partnerWritePro(@Validated PartnerCommand partnerCommand, BindingResult result, HttpServletRequest request) throws Exception{
//		if(result.hasErrors()) {
//			System.out.println("Write Errors");
//			return "thymeleaf/backOfficePage/html/pt_manager/pt_form";
//		}
		String location = partnerWriteService.writePro(partnerCommand, request);
		return location;
	}
	@RequestMapping("partnerDetail/{ptNum}")
	public String partnerDetail(@PathVariable(value="ptNum") String ptNum, Model model) throws Exception{
		partnerDetailService.partnerDetail(ptNum, model);
		return "thymeleaf/backOfficePage/html/pt_manager/pt_view";
	}
	@RequestMapping("partnerModify/{ptNum}")
	public String partnerModify(@PathVariable(value="ptNum") String ptNum, Model model) throws Exception{
		partnerDetailService.partnerDetail(ptNum, model);
		return "thymeleaf/backOfficePage/html/pt_manager/pt_modify";
	}
	@RequestMapping(value="partnerModifyPro/{ptNum}")
	public String partnerModifyPro(PartnerCommand partnerCommand, HttpServletRequest request) throws Exception{
		String path = partnerModifyService.partnerModify(partnerCommand, request);
		return path;
	}
	
	
	
	@RequestMapping("partnerDel/{ptNum}")
	public String partnerDel(@PathVariable(value="ptNum") String ptNum, HttpServletRequest request) throws Exception{
		String path = partnerDeleteService.partnerDelete(ptNum, request);
		return path;
	}
	
}