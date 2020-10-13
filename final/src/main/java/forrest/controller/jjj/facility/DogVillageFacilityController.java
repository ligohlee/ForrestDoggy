package forrest.controller.jjj.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jjj.FacilityCommand;
import forrest.service.jjj.facility.FacilityDeleteService;
import forrest.service.jjj.facility.FacilityDetailService;
import forrest.service.jjj.facility.FacilityInsertService;
import forrest.service.jjj.facility.FacilityListService;
import forrest.service.jjj.facility.FacilityModifyService;

@Controller
@RequestMapping("facility")
public class DogVillageFacilityController {
	@Autowired
	FacilityInsertService facilityInsertService;
	@Autowired
	FacilityListService facilityListService;
	@Autowired
	FacilityDetailService facilityDetailService;
	@Autowired
	FacilityModifyService facilityModifyService;
	@Autowired
	FacilityDeleteService facilityDeleteService;
	
	@RequestMapping(value = "facilityList", method = RequestMethod.GET)
	public String ticketList(Model model) {
		facilityListService.listFacility(model);
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityList";
	}
	@RequestMapping(value = "facilityRegist", method = RequestMethod.GET)
	public String facilityRegist() {
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityRegi";
	}
	@RequestMapping(value = "facilityRegistPro", method = RequestMethod.POST)
	public String facilityRegistPro(FacilityCommand command){
		facilityInsertService.insertFacility(command);
		return "redirect:/dvlback/facilityList";
	}
	@RequestMapping(value = "facilityDetail", method = RequestMethod.GET)
	public String facilityDetail(@RequestParam(value="facilityNum") int facilityNum, Model model) {
		facilityDetailService.selectFacility(facilityNum, model);
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityDetail";
	}
	@RequestMapping(value = "ticketModify", method = RequestMethod.GET)
	public String facilityModify(@RequestParam(value = "facilityNum") int facilityNum, Model model) {
		facilityDetailService.selectFacility(facilityNum,model);
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_facilityModify";
	}
	@RequestMapping(value = "ticketModifyPro", method = RequestMethod.POST)
	public String facilityModifyPro(@RequestParam(value = "facilityNum") int facilityNum,FacilityCommand command) {
		facilityModifyService.modifyFacility(facilityNum,command);
		return "redirect:/dvlback/facilityDetail?facilityNum="+facilityNum;
	}
	@RequestMapping(value = "ticketDelete", method = RequestMethod.GET)
	public String facilityDelete(@RequestParam(value = "facilityNum")int facilityNum) {
		facilityDeleteService.deleteFacility(facilityNum);
		return "redirect:/dvlback/facilityList";
	}
}
