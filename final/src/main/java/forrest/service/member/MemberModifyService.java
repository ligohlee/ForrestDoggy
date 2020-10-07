package forrest.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.member.MemberCommand;
import forrest.domain.MemberDTO;
import forrest.mapper.MemberMapper;

@Service
@Component
public class MemberModifyService {

	@Autowired
	MemberMapper memberMapper;
	
	public void modifyService(String memId, MemberCommand command) {
		
		
		MemberDTO dto = new MemberDTO();
		dto.setMemId(memId);
		dto.setMemName(command.getMemName());
		dto.setMemPh(command.getMemPh());
		dto.setMemAddr(command.getMemAddr());
		dto.setMemEmail(command.getMemEmail());

		memberMapper.updateMember(dto);
		
	}
}
	

