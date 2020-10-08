package forrest.mapper.sy.room;

import java.util.List;

import forrest.domain.sy.room.OptionsDTO;
import forrest.domain.sy.room.RoptionsDTO;

public interface RoptionsMapper {

	List<OptionsDTO> selectRoptions(Integer roomNum);

	void insertRoptions(RoptionsDTO dto);

}
