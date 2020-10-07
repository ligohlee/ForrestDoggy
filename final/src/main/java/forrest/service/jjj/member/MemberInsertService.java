package forrest.service.jjj.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.MemberCommand;
import forrest.domain.jjj.MemberDTO;
import forrest.mapper.jjj.MemberMapper;


@Service
@Component
public class MemberInsertService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	
	public Integer insertMember(MemberCommand command) {
		
		MemberDTO dto = new MemberDTO();
		

		dto.setMemId(command.getMemId());
		dto.setMemName(command.getMemName());
		dto.setMemPass(passwordEncoder.encode(command.getMemPass()));
		dto.setMemAddr(command.getMemAddr());
		dto.setMemEmail(command.getMemEmail());
		dto.setMemPh(command.getMemPh());
		
		Integer i = memberMapper.insertMember(dto);
		
		return i;
	}

}
