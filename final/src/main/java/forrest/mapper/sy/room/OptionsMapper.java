package forrest.mapper.sy.room;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.sy.room.OptionsDTO;



@Repository
@Component
public interface OptionsMapper {

	int insertOpt(OptionsDTO dto);

	List<OptionsDTO> selectOpt();

}
