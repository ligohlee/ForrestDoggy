package forrest.controller.backoffice.partner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ptback")
public class FoodPtController {
	@RequestMapping(value = "foodContract", method = RequestMethod.GET)
	public String foodCT() {
		return "thymeleaf/backOfficePage/html/pt_manager/food_contract";
	}
	@RequestMapping(value = "PtRegist", method = RequestMethod.GET)
	public String foodPtCont() {
		return "thymeleaf/backOfficePage/html/pt_manager/pt_regist";
	}
	

}
