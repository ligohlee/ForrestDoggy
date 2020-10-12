package forrest.controller.ligoh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("esp")
public class ESPMainCtrl {
	
	@RequestMapping(value = "main")
	public String mainOpen() {
		return "thymeleaf/frontPage/html/ligoh/espMain";
	}

}
