package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.ligoh.MenuCommand;
import forrest.service.ligoh.menu.MenuWriteService;

@Controller
@RequestMapping("espback/menu")
public class MemuCtrl {
	

	@Autowired
	MenuWriteService menuWriteService;
	
	@RequestMapping(value = "menuList")
	public String menuList(@RequestParam(value="page", defaultValue="1")Integer page, Model model) throws Exception {
		
		return "thymeleaf/backOfficePage/html/esp_manager/menu/menu_list";
	}
	@RequestMapping(value = "menuRegist", method = RequestMethod.GET)
	public String menuRegist() {
		return "thymeleaf/backOfficePage/html/esp_manager/menu/menu_regist";
	}
	@RequestMapping(value = "menuInsert", method = RequestMethod.POST)
	public String menuInsert(MenuCommand menuCommand, BindingResult result) throws Exception {
		String location = menuWriteService.write(menuCommand);
		return location;
	}

}
