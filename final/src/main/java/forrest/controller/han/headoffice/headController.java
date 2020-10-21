package forrest.controller.han.headoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("head")
public class headController {
	@RequestMapping("main")
	public String main() {
		return "thymeleaf/frontPage/html/han/headofficeinfo";
	}

}
