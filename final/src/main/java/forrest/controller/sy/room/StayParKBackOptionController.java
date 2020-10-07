package forrest.controller.sy.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.command.sy.room.OptionsCommand;
import forrest.service.sy.room.OptionInsertService;
import forrest.service.sy.room.OptionListService;

@Controller
@RequestMapping("stpback")
public class StayParKBackOptionController {
	
	@Autowired
	OptionInsertService optionInsertService;
	@Autowired
	OptionListService optionListService;
	
	@RequestMapping(value = "optionList", method = RequestMethod.GET)
	public String optionList(Model model) {
		optionListService.listOpt(model);
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backOpt";
	}
	@RequestMapping(value = "optionRegi", method = RequestMethod.GET)
	public String optionRegi() {
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backOptRegi";
	}
	@RequestMapping(value = "optionRegiPro", method = RequestMethod.POST)
	public String optionRegiPro(OptionsCommand command) {
		int i = optionInsertService.insertOpt(command);
		if (i==1) {
			return "redirect:/stpback/optionList";
		}else {
			return "thymeleaf/backOfficePage/html/stp_manager/stp_backOptRegi";
		}
		
	}
}
