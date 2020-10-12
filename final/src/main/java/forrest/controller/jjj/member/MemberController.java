package forrest.controller.jjj.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jjj.MemberCommand;
import forrest.service.jjj.member.MemberDetailService;
import forrest.service.jjj.member.MemberInsertService;
import forrest.service.jjj.member.MemberListService;
import forrest.service.jjj.member.MemberModifyService;
import forrest.service.jjj.member.MemberSelectService;

@Controller
@RequestMapping("register")

public class MemberController {

	
	@Autowired
	MemberInsertService memberInsertService;
	
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
	
	
	
	
	
	
	
	
	
	
	
}


