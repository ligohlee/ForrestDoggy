package forrest.controller.jjj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("dogVillage")
public class DogVillageMainController {

	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String dvlMain() {
		return "thymeleaf/frontPage/html/dvlMain";
	}
	
}
