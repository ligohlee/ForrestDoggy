package forrest.service.jjj.member;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.AuthInfo;
import forrest.command.LoginCommand;
import forrest.domain.jjj.MemberDTO;
import forrest.mapper.jjj.MemberMapper;


@Service
@Component
public class MemberSelectService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	AuthInfo authInfo;
	


	public String selectMember(String memId, String memPass, HttpSession session, String backpath, 
			HttpServletRequest request, LoginCommand lc, HttpServletResponse response) {


		
		
		MemberDTO dto = memberMapper.selectMember(lc.getMemId());	
		
		if (passwordEncoder.matches(lc.getMemPass(),dto.getMemPass())) {
			
			authInfo = new AuthInfo(dto.getMemId(), 
					dto.getMemPh(), dto.getMemName(),
					dto.getMemPass());
			
			System.out.println(authInfo.getId());
			
			session.setAttribute("authInfo",authInfo);
			session.setAttribute("login",lc.getMemId());
			
			Boolean idStore = lc.getIdStore();
			Boolean autologin = lc.getAutoLogin();
			System.out.println("autologin : " + autologin);
			if(autologin != null && autologin == true) {
				Cookie cookie = new Cookie("autoLogin", authInfo.getId());
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
			}
			if(idStore != null && idStore == true) {
				Cookie cookie = new Cookie("idStore",authInfo.getId() );
				cookie.setPath("/main");
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
			}else {
				Cookie cookie = new Cookie("idStore",authInfo.getId() );
				cookie.setPath("/main");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			
		    String contextPath = "http://localhost:9090";
	        String command = backpath.substring(contextPath.length());
		
			System.out.println(contextPath);
		    System.out.println(command);
			
			return "redirect:"+ command;
		}else {
			return "thymeleaf/frontPage/html/login";
		}
	}
}
