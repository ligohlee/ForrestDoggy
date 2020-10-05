package forrest.controller.backoffice.member.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.member.MemberCommand;
import forrest.service.member.MemberDetailService;
import forrest.service.member.MemberListService;

@Controller
@RequestMapping("memberlist")
public class MemberBackListController {
	
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String memberList(Model model) {
		memberListService.listMember(model);
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberList";
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String meberDetail(@RequestParam(value = "memId")String memId, Model model, MemberCommand command) {
		memberDetailService.detailService(memId,model,command);
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberDetail";
	}
	@RequestMapping(value = "memberModify", method = RequestMethod.GET)
	public String meberModify(@RequestParam(value = "memId")String memId, MemberCommand command , Model model) {
		memberDetailService.detailService(memId,model,command);
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberModify";
	}
	@RequestMapping(value = "memberModifyPro", method = RequestMethod.POST)
	public String meberModifyPro(@RequestParam(value = "memId")String memId, MemberCommand command , Model model) {
		memberDetailService.detailService(memId,model,command);
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberModifyPro";
	}
}
