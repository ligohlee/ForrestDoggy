package forrest.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.command.member.MemberCommand;

@Controller
@RequestMapping("register")
public class MemberController {
	
	@RequestMapping(value = "agree" , method = RequestMethod.GET)
	public String agree() {
		return "thymeleaf/html/memberAgree" ;
	}
	@RequestMapping(value = "regist" , method = RequestMethod.GET)
	public String memberForm() {
		return "thymeleaf/html/memberForm" ;
	}
	@RequestMapping(value= "memberJoinAction",method = RequestMethod.POST)
	public String memberJoinAction(@Validated MemberCommand memberCommand , BindingResult result , Model model) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/html/memberForm";		
		}else {
			return "thymeleaf/html/succes";	
		}
}
}