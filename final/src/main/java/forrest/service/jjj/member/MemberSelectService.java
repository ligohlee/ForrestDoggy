package forrest.service.jjj.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.domain.jjj.MemberDTO;
import forrest.mapper.jjj.MemberMapper;

@Service
@Component
public class MemberSelectService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String selectMember(String memId, String memPass, HttpSession session) {
		MemberDTO dto = memberMapper.selectMember(memId);
		
		if (passwordEncoder.matches(memPass,dto.getMemPass())) {
			session.setAttribute("login",memId);
			return "redirect:/main";
		}else {
			return "thymeleaf/frontPage/html/login";
		}
	}
	
	
}
