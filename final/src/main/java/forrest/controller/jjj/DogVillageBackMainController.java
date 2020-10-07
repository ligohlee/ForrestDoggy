package forrest.controller.jjj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("dvlback")
public class DogVillageBackMainController {
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String stpMain() {
		return "thymeleaf/backOfficePage/html/dvl_manager/dvl_backMain";
	}
}
