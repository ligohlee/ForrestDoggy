package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.ligoh.menu.MenuListService;

@Controller
@RequestMapping("esp")
public class ESPMenuCtrl {
	
	@Autowired
	MenuListService menuListService;
	
	@RequestMapping(value = "menu")
	public String menuOpen(@RequestParam(value="page", defaultValue="1")Integer page, Model model){
		menuListService.getMenu(page, model);
		return "thymeleaf/frontPage/html/ligoh/espMenu";
	}
	

}
