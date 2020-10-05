package forrest.controller.backoffice.member.list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("memberlist")
public class MemberBackListController {
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String memberList() {
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberList";
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String meberDetail() {
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberDetail";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String meberModify() {
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberModify";
	}
}
