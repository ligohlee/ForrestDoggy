package forrest.controller.jm.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.jm.Inventory.CordListService;

@Controller
@RequestMapping("inventory")
public class InventoryController {
	@Autowired
	CordListService cordListService;
	
	@RequestMapping("cordList")
	public String cordList(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		cordListService.cordList(model, page);
		return "thymeleaf/backOfficePage/html/dgm_manager/cord_list";
	}
}
