package forrest.service.jjj.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.mapper.jjj.MemberMapper;
@Service
@Component
public class MemberDeleteService {

	@Autowired
	MemberMapper memberMapper;
	
	public void deleteService(String memId) {
		
		memberMapper.deleteMember(memId);
	}

}
