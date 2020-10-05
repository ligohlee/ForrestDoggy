package forrest.mapper.backoffice.staypark.room;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.backoffice.staypark.OptionsDTO;

@Repository
@Component
public interface OptionsMapper {

	int insertOpt(OptionsDTO dto);

	List<OptionsDTO> selectOpt();

}
