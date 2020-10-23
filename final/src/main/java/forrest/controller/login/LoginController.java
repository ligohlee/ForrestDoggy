
package forrest.controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
	public String loginPro(String memId, String memPass, HttpSession session, String backpath, HttpServletRequest request, LoginCommand lc, HttpServletResponse response ) {
				
		return memberSelectService.selectMember( memId, memPass, session, backpath, request, lc, response );
	}
	@RequestMapping(value = "logout")
	public String logout(HttpSession session,
			HttpServletResponse response) {
		Cookie autoLoginCookie = new Cookie("autoLogin","");
		autoLoginCookie.setPath("/");
		autoLoginCookie.setMaxAge(0);
		response.addCookie(autoLoginCookie);
		session.invalidate();
		return "thymeleaf/frontPage/html/main";
	}
}
