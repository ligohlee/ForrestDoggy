package forrest.controller.jjj.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("memberback")
public class MemberBackMainController {
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String stpMain() {
		return "thymeleaf/backOfficePage/html/member_manager/member_backMain";
	}
}
