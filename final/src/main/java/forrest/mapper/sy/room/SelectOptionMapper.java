package forrest.mapper.sy.room;

import java.util.List;

import forrest.domain.sy.room.SelectOptionDTO;

public interface SelectOptionMapper {

	void insertSelOpt(SelectOptionDTO dto);
	
	List<SelectOptionDTO> selectOptions(int roNum);
	
	

}
