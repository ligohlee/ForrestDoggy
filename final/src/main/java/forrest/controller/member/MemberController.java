package forrest.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.command.member.MemberCommand;
import forrest.service.member.MemberInsertService;

@Controller
@RequestMapping("register")
public class MemberController {

	@Autowired
	MemberInsertService memberInsertService;

	@RequestMapping(value = "agree", method = RequestMethod.GET)
	public String agree() {
		return "thymeleaf/html/memberAgree";
	}

	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String memberForm() {
		return "thymeleaf/html/memberForm";
	}
	
	@RequestMapping(value= "memberJoinAction",method = RequestMethod.POST)
	public String memberJoinAction(@Validated MemberCommand Command) throws Exception {
		Integer i = memberInsertService.insertMember(Command);
		if (i == 1) {
			return "thymeleaf/html/success";
		}else {
			return "thymeleaf/html/memberForm";	
		}
	}
}