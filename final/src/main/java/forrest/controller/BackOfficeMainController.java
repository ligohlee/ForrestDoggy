package forrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BackOfficeMainController {
	@RequestMapping(value = "backoffice", method = RequestMethod.GET)
	public String stpMain() {
		return "thymeleaf/backOfficePage/html/total_management";
	}
}
