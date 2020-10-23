
package forrest.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.LoginCommand;
import forrest.service.jjj.member.MemberSelectService;
import forrest.service.jm.LoginBackService;

@Controller
public class LoginController {
	
	@Autowired
	MemberSelectService memberSelectService;
	@Autowired
	LoginBackService loginBackService;
		
	@RequestMapping(value = "login")
	public String home(HttpServletRequest request, Model model) throws Exception {
		loginBackService.loginBack(request, model);
		return "thymeleaf/frontPage/html/login";
	}
	@RequestMapping(value="loginPro", method = RequestMethod.POST)
	public String loginPro(@RequestParam(value="memId") String memId, @RequestParam(value="memPass") String memPass,
			HttpSession session,@RequestParam(value="backpath") String backpath, HttpServletRequest request,
			LoginCommand lc, HttpServletResponse response ) {
				
		return memberSelectService.selectMember( memId, memPass, session, backpath, request, lc, response );
	}
	
}
