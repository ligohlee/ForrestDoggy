package forrest.service.jjj.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.AuthInfo;
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
	
	public String selectMember(String memId, String memPass, HttpSession session, String backpath, HttpServletRequest request) {
		
		MemberDTO dto = memberMapper.selectMember(memId);	
		
		if (passwordEncoder.matches(memPass,dto.getMemPass())) {
			
			authInfo = new AuthInfo(dto.getMemId(), 
					dto.getMemPh(), dto.getMemName(),
					dto.getMemPass());
			
			System.out.println(authInfo.getId());
			
			session.setAttribute("authInfo",authInfo);
			session.setAttribute("login",memId);
			
		    String contextPath = "http://localhost:9090";
		    String command = backpath.substring(contextPath.length());
			
			System.out.println(contextPath);
			System.out.println(command);
			
			return "redirect:"+command;
		}else {
			return "thymeleaf/frontPage/html/login";
		}
	}
}
