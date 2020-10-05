package forrest.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.member.MemberCommand;
import forrest.domain.MemberDTO;
import forrest.mapper.MemberMapper;

@Service
@Component
public class MemberDetailService {

	@Autowired
	MemberMapper memberMapper;
	
	public void detailService(String memId, Model model, MemberCommand memberCommand) {
	MemberDTO dto = new MemberDTO();
	dto.setMemId(memId);
	MemberDTO member = memberMapper.selectMember(memId);
	model.addAttribute("memberCommand",member);
	}

	
}