package forrest.controller.jjj.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jjj.FacilityCommand;
import forrest.service.jjj.facility.FacilityDetailService;
import forrest.service.jjj.facility.FacilityInsertService;
import forrest.service.jjj.facility.FacilityListService;
import forrest.service.jjj.facility.FacilityModifyService;

@Controller
@RequestMapping("facility")
public class DogViliageBackFacilityController {
	
	@Autowired
	FacilityInsertService facilityInsertService;
	@Autowired
	FacilityListService facilityListService;
	@Autowired
	FacilityDetailService facilityDetailService;
	@Autowired
	FacilityModifyService facilityModifyService;
	
	@RequestMapping(value = "facilityList", method = RequestMethod.GET)
	public String facilityList(Model model) {
		facilityListService.listFacility(model);
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityList";
	}
	@RequestMapping(value = "facilityRegi", method = RequestMethod.GET)
	public String facilityRegist() {
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityRegi";
	}
	@RequestMapping(value = "facilityRegiPro", method = RequestMethod.POST)
	public String facilityRegistPro(FacilityCommand facCommand) {
		facilityInsertService.insertFacility(facCommand);
	return "redirect:/facility/facilityList";
	}
	@RequestMapping(value = "facilityDetail", method = RequestMethod.GET)
	public String facilityDetail(@RequestParam(value="facNum") int facNum, Model model){
		facilityDetailService.detailFacility(facNum,model);
		return"thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityDetail";
	}
	@RequestMapping(value = "facilityModify", method = RequestMethod.GET)
	public String facilityModify(@RequestParam(value = "facNum") int facNum, Model model) {
		facilityDetailService.detailFacility(facNum,model);	
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityModify";
	}
	@RequestMapping(value = "facilityModifyPro", method = RequestMethod.POST)
	public String facilityModifyPro(@RequestParam(value="facNum") int facNum,FacilityCommand facCommand) {
		facilityModifyService.modifyFacility(facNum,facCommand);
		return "redirect:/facility/facilityDetail?facNum="+facNum;
	}
}
