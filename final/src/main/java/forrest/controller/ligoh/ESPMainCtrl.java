package forrest.controller.ligoh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("esp")
public class ESPMainCtrl {
	
	@RequestMapping(value = "main")
	public String mainOpen(Model model) {
		 Integer [] num = {1,2};
		 model.addAttribute("num", num);
		return "thymeleaf/frontPage/html/ligoh/espMain";
	}

}
