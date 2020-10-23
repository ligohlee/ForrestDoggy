package forrest.service.jjj.member;

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
public class MemberSelectService2 {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	AuthInfo authInfo;

	public void selectMember(String memId, String memPass, HttpSession session) {
		
		System.out.println(memId);
		System.out.println(memPass);

		MemberDTO dto = memberMapper.selectMember(memId);
		System.out.println(dto);

		if (passwordEncoder.matches(memPass, dto.getMemPass())) {

			authInfo = new AuthInfo(dto.getMemId(), dto.getMemPh(), dto.getMemName(), dto.getMemPass());

			System.out.println(authInfo.getId());

			session.setAttribute("authInfo", authInfo);

		}
	}
}
