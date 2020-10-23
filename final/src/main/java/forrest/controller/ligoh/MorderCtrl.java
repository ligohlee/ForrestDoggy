package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.ligoh.morder.MorderListService;

@Controller
@RequestMapping("espback/order")
public class MorderCtrl {
	@Autowired
	MorderListService morderListService;
	
	
	@RequestMapping(value = "list")
	public String menuOpen(Model model,
			@RequestParam(value="page", defaultValue="1")Integer page) throws Exception{
		morderListService.getOrderList(model, page);
		return "thymeleaf/backOfficePage/html/esp_manager/order/order_list";
	}

}
