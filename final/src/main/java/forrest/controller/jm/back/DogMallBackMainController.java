package forrest.controller.jm.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("dgmback")
public class DogMallBackMainController {
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String dgmMain() {
		return "thymeleaf/backOfficePage/html/dgm_manager/dgm_backMain";
	}
	
	
}
