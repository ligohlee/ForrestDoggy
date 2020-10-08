package forrest.mapper.sy.room;

import java.util.List;

import forrest.domain.sy.room.OptionsDTO;
import forrest.domain.sy.room.RoomDTO;
import forrest.domain.sy.room.RoptionsDTO;





public interface RoomMapper {

	void insertRoom(RoomDTO dto);

	List<RoomDTO> selectRoom(Integer roomNum);

	void insertRoptions(RoptionsDTO dto);

	List<OptionsDTO> selectRoptions(Integer roomNum);

}
