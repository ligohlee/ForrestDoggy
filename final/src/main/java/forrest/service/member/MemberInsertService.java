package forrest.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.member.MemberCommand;
import forrest.domain.MemberDTO;
import forrest.mapper.MemberMapper;

@Service
@Component
public class MemberInsertService {

	@Autowired
	MemberMapper MemberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public Integer insertMember(MemberCommand command)  throws Exception{
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMemId(command.getMemId());
		dto.setMemName(command.getMemName());
		dto.setMemPass(passwordEncoder.encode(command.getMemPass()));
		dto.setMemAddr(command.getMemAddr());
		dto.setMemEmail(command.getMemEmail());
		dto.setMemPh(command.getMemPh());
		System.out.println(dto.getMemAddr());
		Integer i = MemberMapper.insertMember(dto);
		System.out.println(i);
		return i;
	}

}