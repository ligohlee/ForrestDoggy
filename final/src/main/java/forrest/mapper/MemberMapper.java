package forrest.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.MemberDTO;

@Repository
@Component
public interface MemberMapper {

	Integer insertMember(MemberDTO dto) throws Exception;

}
