package forrest.controller.login;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forrest.command.LoginCommand;
import forrest.service.jjj.member.MemberSelectService;

@Controller
public class LoginController {
	
	@Autowired
	MemberSelectService memberSelectService;
		
	@RequestMapping(value = "login")
	public String home() {
		return "thymeleaf/frontPage/html/login";
	}
	@RequestMapping(value="loginPro", method = RequestMethod.POST)
	public String loginPro(LoginCommand lc, HttpSession session,HttpServletResponse response ) {
				
		return memberSelectService.selectMember(lc ,session, response );
	}
	@RequestMapping(value = "logout")
	public String logout() {
		
		return "thymeleaf/frontPage/html/login";
	}
}
