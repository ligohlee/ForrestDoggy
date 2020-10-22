package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import forrest.service.ligoh.morder.MorderListService;

@Controller
@RequestMapping("espback/order")
public class MorderCtrl {
	@Autowired
	MorderListService morderListService;
	
	
	@RequestMapping(value = "list")
	public String menuOpen(Model model) throws Exception{
		morderListService.getOrderList(model);
		return "thymeleaf/backOfficePage/html/esp_manager/order/order_list";
	}

}
