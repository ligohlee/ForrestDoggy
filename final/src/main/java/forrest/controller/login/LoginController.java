package forrest.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value = "login")
	public String home() {
		
		return "thymeleaf/frontPage/html/login";
	}
}
