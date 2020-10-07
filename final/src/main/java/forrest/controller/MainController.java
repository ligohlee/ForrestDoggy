package forrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value = "main")
	public String home() {
		
		return "thymeleaf/frontPage/html/main";
	}
}
