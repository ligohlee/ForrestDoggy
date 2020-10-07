package forrest.mapper.sy;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.sy.OptionsDTO;

@Repository
@Component
public interface OptionsMapper {

	int insertOpt(OptionsDTO dto);

	List<OptionsDTO> selectOpt();

}
