package forrest.controller.jjj.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import forrest.command.jjj.MemberCommand;
import forrest.command.sy.PointCommand;
import forrest.service.jjj.member.MemberDetailService;
import forrest.service.jjj.member.MemberInsertService;
import forrest.service.jjj.member.MemberListService;
import forrest.service.jjj.member.MemberModifyService;
import forrest.service.sy.PointService;

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
	@Autowired
	PointService pointService;
	
	@RequestMapping(value="agree", method = RequestMethod.GET)
	public String agree () {
		return "thymeleaf/frontPage/html/member/memberAgree";
	}
	@RequestMapping(value="regist", method = RequestMethod.GET)
	public String regist() {
		return "thymeleaf/frontPage/html/member/memberForm";
	}
	@RequestMapping(value="memberJoinAction", method = RequestMethod.POST)
	public String memberJoinAction(MemberCommand command, PointCommand pcommand) {
		Integer i = memberInsertService.insertMember(command);
		if (i == 1) {
			pointService.insertPoint(pcommand);
			return "thymeleaf/frontPage/html/member/success" ;
		}
		return "thymeleaf/frontPage/html/member/memberForm" ;
	}
	
	
	
	
	
	
	
	
	
	
	
}


