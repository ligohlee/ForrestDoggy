package forrest.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String loginPro(@RequestParam(value = "memId")String memId ,@RequestParam(value = "memPass")String memPass ,HttpSession session) {
			
		return memberSelectService.selectMember(memId , memPass ,session );
	}
	@RequestMapping(value = "logout")
	public String logout() {
		
		return "thymeleaf/frontPage/html/login";
	}
}
