package forrest.mapper.jjj;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jjj.MemberDTO;

@Repository
@Component
public interface MemberMapper {

	Integer insertMember(MemberDTO dto);

	MemberDTO selectMember(String memId);
	List<MemberDTO>   selectMemberAll();

	void updateMember(MemberDTO dto);

	void deleteMember(String memId);
	

}
