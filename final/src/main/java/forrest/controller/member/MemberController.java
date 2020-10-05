package forrest.controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.member.MemberCommand;
import forrest.service.member.MemberDetailService;
import forrest.service.member.MemberInsertService;
import forrest.service.member.MemberListService;
import forrest.service.member.MemberModifyService;
import forrest.service.member.MemberSelectService;

@Controller
@RequestMapping("register")

public class MemberController {

	
	@Autowired
	MemberInsertService memberInsertService;
	@Autowired
	MemberSelectService memberSelectService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberModifyService memberModifyService;
	
	@RequestMapping(value="agree", method = RequestMethod.GET)
	public String agree () {
		return "thymeleaf/html/memberAgree";
	}
	@RequestMapping(value="regist", method = RequestMethod.GET)
	public String regist() {
		return "thymeleaf/html/memberForm";
	}
	@RequestMapping(value="memberJoinAction", method = RequestMethod.POST)
	public String memberJoinAction(MemberCommand command) {
		Integer i = memberInsertService.insertMember(command);
		if (i == 1) {
			return "thymeleaf/html/success" ;
		}
		return "thymeleaf/html/memberForm" ;
	}
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login() {
		return "thymeleaf/html/login";
	}
	@RequestMapping(value="loginPro", method = RequestMethod.POST)
	public String loginPro(@RequestParam(value = "memId")String memId ,@RequestParam(value = "memPass")String memPass ,HttpSession session) {
		
	
		return memberSelectService.selectMember(memId , memPass ,session );
	}
	
	
	
	
	
	
	
	
	
}


